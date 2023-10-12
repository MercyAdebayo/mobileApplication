package com.example.mercyadebayo_comp304sec001_lab02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.productImage.setImageResource(product.imageResource)
        holder.productName.text = product.name
        holder.productPrice.text = product.price.toString()
    }

    override fun getItemCount() = productList.size
}