package com.example.shoes.adaptar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes.DetailsActivity
import com.example.shoes.databinding.MenuItemBinding

class MenuAdaptar(private val menuItemsName: List<String>, private val menuItemPrice: List<String>, private val MenuImage: List<Int>, private val requiereContext: Context): RecyclerView.Adapter<MenuAdaptar.menuViewHolder>() {

    private val itemClickListener: OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return menuViewHolder(binding)
    }


    override fun onBindViewHolder(holder: menuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = menuItemsName.size

    inner class menuViewHolder (private  val binding: MenuItemBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                //setOnClic listener to open details

                val intent = Intent(requiereContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName", menuItemsName.get(position))
                intent.putExtra("MenuItemImage", MenuImage.get(position))
                requiereContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menuClothesName.text = menuItemsName[position]
                menuPrice.text = menuItemPrice[position]
                menuImage.setImageResource(MenuImage[position])



            }
        }

    }
    interface OnClickListener{
        fun onItemClick(position: Int)

    }
}


