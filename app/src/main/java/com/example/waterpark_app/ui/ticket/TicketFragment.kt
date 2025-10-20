package com.example.waterpark_app.ui.ticket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.waterpark_app.databinding.FragmentTicketBinding
import com.example.waterpark_app.ui.main.MainActivity

class TicketFragment : Fragment() {

    private var _binding: FragmentTicketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)

        binding.apply {
            // Akses tombol di dalam layout include

            tiketCard.btnBooking.setOnClickListener {
                val intent = Intent(requireActivity(), DetailTicketActivity::class.java)
                startActivity(intent)
            }
        }

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Akses komponen lewat binding
//        binding.btnBooking.setOnClickListener {
//            val intent = Intent(requireActivity(), DetailTicketActivity::class.java)
//            startActivity(intent)
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
