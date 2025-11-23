package com.example.waterpark_app.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.waterpark_app.data.model.HistoryModel
import com.example.waterpark_app.databinding.HistoryItemCardBinding

class HistoryAdapter(
    private val historyList: List<HistoryModel>
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: HistoryItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HistoryItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = historyList[position]

        holder.binding.apply {
            tvPackageTitle.text = item.title
            tvPackageSubtitle.text = item.subtitle
            tvVisitDate.text = "Visited on: ${item.visitDate}"
            tvPrice.text = "Rp ${item.totalPrice}"
            tvStatusBadge.text = item.status
            tvOrderId.text = "Order #${item.orderId}"

            btnViewTicket.setOnClickListener {
                Toast.makeText(
                    root.context,
                    "Lihat tiket: ${item.title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int = historyList.size
}
