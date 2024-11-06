package com.example.shoes.fragment

import android.app.DownloadManager.Query
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoes.R
import com.example.shoes.adaptar.MenuAdaptar
import com.example.shoes.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdaptar
    private val originalMenuClothesName = listOf(
        "chaueta", "buzo", "saco", "chompo")
    private val originalMenuitemPrice = listOf(
        "130.000", "200.000", "124.000","100.000")
    private val originalMenuImage = listOf(
        R.drawable.rop4,
        R.drawable.rop5,
        R.drawable.rop6,
        R.drawable.rop1
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuClothesName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdaptar(filteredMenuClothesName,filteredMenuItemPrice,filteredMenuImage, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //setup search view
        setupSearchView()
        //mostrar todos los items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuClothesName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuClothesName.addAll(originalMenuClothesName)
        filteredMenuItemPrice.addAll(originalMenuitemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })


    }

    private fun filterMenuItems(query: String) {
        filteredMenuClothesName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuClothesName.forEachIndexed { index, clothesName ->
            if(clothesName.contains(query, ignoreCase = true)){
                filteredMenuClothesName.add(clothesName)
                filteredMenuItemPrice.add(originalMenuitemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }




    companion object {

    }
}

