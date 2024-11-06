package com.example.shoes.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes.databinding.BuyAgainItemBinding

class buyAgainAdapter(private val buyAgainClothesName: ArrayList<String>, private val
 buyAgainClothesPrice:ArrayList<String>, private val buyAgainClothesImage: ArrayList<Int>):
    RecyclerView.Adapter<buyAgainAdapter.BuyagainViewHolder>() {

    override fun onBindViewHolder(holder: BuyagainViewHolder, position: Int) {
        holder.bind(buyAgainClothesName[position],buyAgainClothesPrice[position],buyAgainClothesImage[position])
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyagainViewHolder {
       val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return BuyagainViewHolder(binding)
    }

    override fun getItemCount(): Int = buyAgainClothesName.size
    class BuyagainViewHolder(private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder
        (binding.root){
        fun bind(clothesName: String, clothesPrice: String, clothesImage: Int) {
           binding.buyAgainClothesName.text=clothesName
            binding.buyAgainClothesPrice.text = clothesPrice
            binding.buyAgainClothesImage.setImageResource(clothesImage)
        }

    }


}