package com.example.shoes.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes.databinding.ActivitySplashScreenBinding
import com.example.shoes.databinding.CartItemBinding

class CartAdaptar(private val cartitems: MutableList<String>, private val CartItemPrice:MutableList<String>, private var cartimage: MutableList<Int>): RecyclerView.Adapter<CartAdaptar.CartViewHolder>() {

    private val itemQuantities = IntArray(cartitems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding= CartItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return  CartViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
       holder.bin(position)
    }

    override fun getItemCount(): Int = cartitems.size

    inner class CartViewHolder(private val binding: CartItemBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bin(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartClothesName.text = cartitems[position]
                cartitemprice.text = CartItemPrice[position]
                cartImage.setImageResource(cartimage[position])
                cartitemQuantity.text = quantity.toString()

                minusbutton.setOnClickListener {
                    deceaseQuantity(position)
                }

                plusbutton.setOnClickListener{
                    increaseQuantity(position)
                }

                deleteButton.setOnClickListener{
                  val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(itemPosition)
                    }
                }

            }
        }
        fun increaseQuantity(position: Int){
            if(itemQuantities[position]<10){
                itemQuantities[position]++
                binding.cartitemQuantity.text = itemQuantities[position].toString()
            }

        }
        private  fun deceaseQuantity(position: Int){
            if(itemQuantities[position]>1){
                itemQuantities[position]--
                binding.cartitemQuantity.text = itemQuantities[position].toString()
            }

        }
        private fun deleteItem(position: Int){
            cartitems.removeAt(position)
            cartimage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartitems.size)

        }

    }
}