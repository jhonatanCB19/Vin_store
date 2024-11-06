package com.example.shoes.adaptar

import android.content.Context
import android.content.Intent
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes.DetailsActivity
import com.example.shoes.databinding.ItemPopularBinding

class PopularAddaptar(private  val  items:List<String>,private val price:List<String>, private val image:List<Int>, private val requiereContext: Context): RecyclerView.Adapter<PopularAddaptar.PouplerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
       return PouplerViewHolder(ItemPopularBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items[position]
        val price = price[position]
        val images = image[position]
        holder.bind(item,price,images)



        holder.itemView.setOnClickListener{
            val intent = Intent(requiereContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName", item)
            intent.putExtra("MenuItemImage", images)
            requiereContext.startActivity(intent)

        }
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class PouplerViewHolder (private val binding: ItemPopularBinding) : RecyclerView.ViewHolder(binding.root) {
       private val imagesView = binding.imageView3

        fun bind(item: String,price: String, images: Int) { // price va sin el list
            binding.NombreRopaPopular.text = item
            binding.PricePopular.text = price
            imagesView.setImageResource(images)
        }


        }

    }

