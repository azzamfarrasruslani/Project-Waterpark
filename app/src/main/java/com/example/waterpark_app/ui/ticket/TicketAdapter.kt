package com.example.waterpark_app.ui.ticket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.waterpark_app.R
import com.google.android.material.imageview.ShapeableImageView

class TicketAdapter(
    private val ticketList: List<TicketModel>,
    private val onItemClick: (TicketModel) -> Unit
) : RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    inner class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPackage: ShapeableImageView = itemView.findViewById(R.id.imgPackage)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvOriginalPrice: TextView = itemView.findViewById(R.id.tvStrikethroughPrice)
        val tvDiscount: TextView = itemView.findViewById(R.id.tvDiscount)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        val btnBooking: Button = itemView.findViewById(R.id.btnBooking)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ticket_item_card, parent, false)
        return TicketViewHolder(view)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = ticketList[position]
        holder.imgPackage.setImageResource(ticket.imageResId)
        holder.tvTitle.text = ticket.title
        holder.tvDesc.text = ticket.description
        holder.tvPrice.text = ticket.price
        holder.tvOriginalPrice.text = ticket.originalPrice
        holder.tvDiscount.text = ticket.discount
        holder.tvRating.text = "${ticket.rating} (${ticket.reviews})"

        holder.btnBooking.setOnClickListener {
            onItemClick(ticket)
        }
    }

    override fun getItemCount(): Int = ticketList.size
}
