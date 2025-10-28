package com.example.waterpark_app.ui.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.waterpark_app.databinding.HistoryItemCardBinding

class HistoryAdapter(
    context: Context,
    private val historyList: List<HistoryModel>
) : ArrayAdapter<HistoryModel>(context, 0, historyList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: HistoryItemCardBinding =
            HistoryItemCardBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val item = historyList[position]

        binding.tvPackageTitle.text = item.title
        binding.tvPackageSubtitle.text = item.subtitle
        binding.tvVisitDate.text = "Visited on: ${item.visitDate}"
        binding.tvPrice.text = item.price
        binding.tvStatusBadge.text = item.status
        binding.tvOrderId.text = "Order #${item.orderId}"

        binding.btnViewTicket.setOnClickListener {
            Toast.makeText(
                context,
                "Lihat tiket: ${item.title}",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
