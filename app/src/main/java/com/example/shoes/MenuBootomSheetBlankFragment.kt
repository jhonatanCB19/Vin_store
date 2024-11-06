package com.example.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoes.adaptar.MenuAdaptar
import com.example.shoes.databinding.FragmentMenuBootomSheetBlankBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBootomSheetBlankFragment : BottomSheetDialogFragment() {
   private lateinit var binding: FragmentMenuBootomSheetBlankBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentMenuBootomSheetBlankBinding.inflate(inflater,container, false)

         binding.buttonBack.setOnClickListener{
             dismiss()
         }

        val menuClothesName = listOf("chaueta", "buzo", "saco", "chompo")
        val menuitemPrice = listOf("130.000", "200.000", "124.000","100.000")
        val menuImage = listOf(
            R.drawable.rop4,
            R.drawable.rop5,
            R.drawable.rop6,
            R.drawable.rop1
        )
        val adaptar = MenuAdaptar(ArrayList(menuClothesName),ArrayList(menuitemPrice), ArrayList(menuImage),requireContext())
        binding.menuRecyclerMenu.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerMenu.adapter = adaptar
        return binding.root
    }

    companion object {

    }
}