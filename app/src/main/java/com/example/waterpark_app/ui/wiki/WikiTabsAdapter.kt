package com.example.waterpark_app.ui.wiki

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class WikiTabsAdapter (activity: FragmentActivity) : FragmentStateAdapter(activity) {
    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 4

    // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            2 -> Tab3Fragment()
            3 -> Tab4Fragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}

