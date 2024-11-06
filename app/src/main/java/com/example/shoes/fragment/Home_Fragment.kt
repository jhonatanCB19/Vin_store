package com.example.shoes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.shoes.MenuBootomSheetBlankFragment
import com.example.shoes.R
import com.example.shoes.adaptar.PopularAddaptar
import com.example.shoes.databinding.FragmentHomeBinding

class Home_Fragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)


        binding.ViewAllMenu.setOnClickListener{
            val bottomSheetDialog = MenuBootomSheetBlankFragment()
            bottomSheetDialog.show(parentFragmentManager, "test")
        }
        return binding.root


    }
     // codigo para mostrar las ofertas famosas
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.ofertastienda, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.ofertas3, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.ofertas4, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imagelist)
        imageSlider.setImageList(imagelist, ScaleTypes.FIT)
         imageSlider.setItemClickListener(object :ItemClickListener{
             override fun doubleClick(position: Int) {
                 TODO("Not yet implemented")
             }

             override fun onItemSelected(position: Int) {
                 val itemPosition = imagelist[position]
                 val itemMessage = "Seleccionar imagen $position"
                 Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
             }
         })
         val nombreRopa = listOf("Pantalon","chaqueta", "gorra","item")
         val Price = listOf("$170.000","$90.000","$120.000", "$85.000")
         val popularRopaImages
                = listOf(R.drawable.rop1,R.drawable.rop2,R.drawable.rop3,R.drawable.rop4)
         val adapter = PopularAddaptar(nombreRopa,Price,popularRopaImages,requireContext())
         binding.PopulerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
         binding.PopulerRecyclerView.adapter = adapter

    }
    companion object{

    }


}