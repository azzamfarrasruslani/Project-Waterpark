package com.example.waterpark_app.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waterpark_app.data.model.ShopModel
import com.example.waterpark_app.data.repository.ShopRepository
import com.example.waterpark_app.databinding.FragmentShopBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopFragment : Fragment() {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!

    private val repository = ShopRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fetchShopItems()
    }

    private fun fetchShopItems() {
        binding.progressBar.visibility = View.VISIBLE

        repository.getAllShopItems().enqueue(object : Callback<List<ShopModel>>
        {

            override fun onResponse(
                call: Call<List<ShopModel>>,
                response: Response<List<ShopModel>>
            ) {
                binding.progressBar.visibility = View.GONE

                if (response.isSuccessful) {
                    val items = response.body() ?: emptyList()

                    binding.rvShop.layoutManager = GridLayoutManager(requireContext(), 1)
                    binding.rvShop.adapter = ShopAdapter(items)
                } else {
                    Toast.makeText(requireContext(), "Gagal memuat merchandise", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ShopModel>>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
