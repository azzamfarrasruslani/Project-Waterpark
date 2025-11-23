package com.example.waterpark_app.ui.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waterpark_app.data.model.ShopModel
import com.example.waterpark_app.databinding.ShopItemCardBinding

class ShopAdapter(
    private val items: List<ShopModel>
) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    inner class ShopViewHolder(val binding: ShopItemCardBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = ShopItemCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val item = items[position]

        holder.binding.tvName.text = item.name
        holder.binding.tvDescription.text = item.description
        holder.binding.tvPrice.text = "Rp ${item.price}"
        holder.binding.tvStock.text = "Stok: ${item.stock}"

        Glide.with(holder.itemView.context)
            .load(item.image_url)
            .into(holder.binding.ivImage)
    }

    override fun getItemCount(): Int = items.size
}
