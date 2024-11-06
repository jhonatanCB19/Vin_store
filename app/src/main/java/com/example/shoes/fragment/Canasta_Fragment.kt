package com.example.shoes.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoes.CongratsBottomSheet
import com.example.shoes.PayOutActivity
import com.example.shoes.R
import com.example.shoes.adaptar.CartAdaptar
import com.example.shoes.databinding.CartItemBinding
import com.example.shoes.databinding.FragmentCanastaBinding


class Canasta_Fragment : Fragment() {
    private lateinit var binding: FragmentCanastaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCanastaBinding.inflate(inflater,container, false)


        val cartClothesName = listOf("chaueta", "buzo", "saco", "chompo")
        val cartitemPrice = listOf("130.000", "200.000", "124.000","100.000")
        val cartImage = listOf(
            R.drawable.rop4,
            R.drawable.rop5,
            R.drawable.rop6,
            R.drawable.rop1
        )
        val adaptar = CartAdaptar(ArrayList(cartClothesName),ArrayList(cartitemPrice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adaptar
        binding.poceedButton.setOnClickListener {
            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    companion object {

    }
}