package com.example.shoes.fragment

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoes.R
import com.example.shoes.adaptar.buyAgainAdapter
import com.example.shoes.databinding.FragmentHistoryBinding


class History_Fragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: buyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecyclerView()
        return  binding.root
    }
private fun setupRecyclerView(){
    val buyAgainClothesName = arrayListOf("ropa 1","ropa 2","ropa 3")
    val buyAgainClothesPrice = arrayListOf("$10.000","$80.000","$10.000")
    val buyAgainClothesImage = arrayListOf(R.drawable.rop4,R.drawable.rop1,R.drawable.rop3)
    buyAgainAdapter = buyAgainAdapter(buyAgainClothesName,buyAgainClothesPrice,buyAgainClothesImage)
    binding.BuyAgainRecyclerView.adapter = buyAgainAdapter
    binding.BuyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())

}
    companion object {

    }
}