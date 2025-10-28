package com.example.waterpark_app.ui.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.waterpark_app.databinding.TicketItemCardBinding

class TicketAdapter(
    private val ticketList: List<TicketModel>,
    private val onItemClick: (TicketModel) -> Unit
) : RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    inner class TicketViewHolder(val binding: TicketItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding = TicketItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = ticketList[position]
        holder.binding.apply {
            imgPackage.setImageResource(ticket.imageResId)
            tvTitle.text = ticket.title
            tvDesc.text = ticket.description
            tvPrice.text = ticket.price
            tvStrikethroughPrice.text = ticket.originalPrice
            tvDiscount.text = ticket.discount
            tvRating.text = "${ticket.rating} (${ticket.reviews})"
            btnBooking.setOnClickListener {
                onItemClick(ticket)
            }
        }
    }

    override fun getItemCount(): Int = ticketList.size
}
