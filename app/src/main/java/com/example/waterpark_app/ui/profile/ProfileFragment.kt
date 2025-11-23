package com.example.waterpark_app.ui.profile

import android.content.Intent
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.waterpark_app.databinding.FragmentProfileBinding
import com.example.waterpark_app.ui.login.LoginActivity
import com.example.waterpark_app.ui.wiki.WikiActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val sharedPref = requireActivity().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.apply {
            profileSettings.logoutRow.setOnClickListener {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Konfirmasi")
                    .setMessage("Apakah Ingin Keluar")
                    .setPositiveButton("Ya") { dialog, _ ->
                        dialog.dismiss()
                        val editor = sharedPref.edit()
                        editor.clear()
                        editor.apply()

                        dialog.dismiss()
                        val intent = Intent(requireActivity(), LoginActivity::class.java)
                        startActivity(intent)

                    }
                    .setNegativeButton("Batal") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }

            profileSettings.paymentRow.setOnClickListener {
                Toast.makeText(requireContext(), "Payment diklik", Toast.LENGTH_SHORT).show()
            }

            profileSettings.wikiRow.setOnClickListener {
                val intent = Intent(requireActivity(), WikiActivity::class.java)
                startActivity(intent)
            }

            profileSettings.notificationsRow.setOnClickListener {
                val intent = Intent(requireActivity(), NotificationActivity::class.java)
                startActivity(intent)
            }


        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
