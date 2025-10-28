package com.example.waterpark_app.ui.ticket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waterpark_app.R
import com.example.waterpark_app.databinding.FragmentTicketBinding

class TicketFragment : Fragment() {

    private var _binding: FragmentTicketBinding? = null
    private val binding get() = _binding!!

    private val ticketList = listOf(
        TicketModel(
            "Family Pass",
            "2 Adults + 2 Children",
            "$89",
            "$110",
            "20% OFF",
            4.9,
            "2.1k reviews",
            "Book Now",
            R.drawable.ticket_family
        ),
        TicketModel(
            "Single Adult Ticket",
            "1 Adult | Access All Slides",
            "$35",
            "$45",
            "22% OFF",
            4.7,
            "1.8k reviews",
            "Book Now",
            R.drawable.ticket_adult
        ),
        TicketModel(
            "Kids Splash Pass",
            "1 Child (Under 12)",
            "$25",
            "$30",
            "15% OFF",
            4.8,
            "1.5k reviews",
            "Book Now",
            R.drawable.ticket_kids
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = TicketAdapter(ticketList) { ticket ->
            val intent = Intent(requireActivity(), DetailTicketActivity::class.java)
            intent.putExtra("ticket_title", ticket.title)
            startActivity(intent)
        }

        // Pasangkan adapter ke RecyclerView
        binding.recyclerViewTickets.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTickets.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
