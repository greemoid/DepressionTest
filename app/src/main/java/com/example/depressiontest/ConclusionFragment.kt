package com.example.depressiontest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.depressiontest.databinding.FragmentConclusionBinding


class ConclusionFragment : Fragment() {

    private var _binding: FragmentConclusionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentConclusionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sum = arguments?.getInt("sum", 0) ?: 0


        binding.textviewSecond.text = when(sum) {
            in 0..30 -> requireContext().getString(R.string.twenty_thirty)
            in 31..38 -> requireContext().getString(R.string.thirtyone_thirtyeight)
            in 39..50 -> requireContext().getString(R.string.thirtynine_fifty)
            in 51..63 -> requireContext().getString(R.string.fifty_sixtythree)
            in 64..80 -> requireContext().getString(R.string.sixtythree_eighteen)
            else -> requireContext().getString(R.string.twenty_thirty)
        }

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_conclusionFragment_to_introFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}