package com.example.waterpark_app.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.waterpark_app.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val historyList = listOf(
        HistoryModel("Family Pass", "2 Adults + 2 Kids", "15 Sept 2025", "$120.00", "✔ Used", "WP2025091501"),
        HistoryModel("Single Adult Ticket", "1 Adult", "12 Sept 2025", "$45.00", "✔ Used", "WP2025091202"),
        HistoryModel("Kids Splash Pass", "1 Child", "10 Sept 2025", "$25.00", "✔ Used", "WP2025091003")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Riwayat Transaksi"
        }


        val adapter = HistoryAdapter(requireContext(), historyList)
        binding.listViewHistory.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
