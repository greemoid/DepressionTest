package com.example.depressiontest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.depressiontest.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    private lateinit var titles: Array<String>
    private lateinit var descriptions: Array<String>

    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titles = resources.getStringArray(R.array.intro_titles)
        descriptions = resources.getStringArray(R.array.intro_descriptions)

        // Set initial text+anim
        startAnimation()
        updateView()



        // Set "Next" button click listener
        binding.nextButton.setOnClickListener {

            currentIndex++
            if (currentIndex < titles.size - 1) {
                // Update text
                updateView()
            } else if (currentIndex == titles.size - 1) {
                // Hide "Next" button
                binding.nextButton.visibility = View.GONE
                updateView()
                // Show "Start" button
                binding.btnStart.visibility = View.VISIBLE
                binding.btnStart.setOnClickListener {
                    findNavController().navigate(R.id.action_introFragment_to_testFragment)
                }
            }
        }
    }

    private fun updateView() {
        binding.titleText.text = titles[currentIndex]
        binding.descriptionText.text = descriptions[currentIndex]
        startAnimation()
    }

    private fun startAnimation() {
        val animTitle = AnimationUtils.loadAnimation(requireContext(), R.anim.text_fade_in)
        val animDescription = AnimationUtils.loadAnimation(requireContext(), R.anim.text_fade_in)

        binding.titleText.startAnimation(animTitle)
        binding.descriptionText.startAnimation(animDescription)
    }
}