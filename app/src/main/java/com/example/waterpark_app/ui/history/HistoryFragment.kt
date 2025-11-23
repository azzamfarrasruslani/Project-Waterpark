package com.example.waterpark_app.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waterpark_app.data.model.HistoryModel
import com.example.waterpark_app.data.repository.HistoryRepository
import com.example.waterpark_app.databinding.FragmentHistoryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    // Gunakan repository, jangan API langsung
    private val repository = HistoryRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Riwayat Transaksi"

        fetchHistory()
    }

    private fun fetchHistory() {
        binding.progressBar.visibility = View.VISIBLE

        repository.getAllHistory().enqueue(object : Callback<List<HistoryModel>> {

            override fun onResponse(
                call: Call<List<HistoryModel>>,
                response: Response<List<HistoryModel>>
            ) {
                binding.progressBar.visibility = View.GONE

                if (response.isSuccessful) {
                    val data = response.body() ?: emptyList()

                    val adapter = HistoryAdapter(data)
                    binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
                    binding.rvHistory.adapter = adapter

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Gagal memuat data riwayat",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<HistoryModel>>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    "Error: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
