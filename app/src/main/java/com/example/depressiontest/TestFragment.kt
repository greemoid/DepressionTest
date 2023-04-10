package com.example.depressiontest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.depressiontest.databinding.FragmentTestBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root

    }

    data class Item(
        val first: Pair<Int, String>,
        val second: Pair<Int, String>,
        val third: Pair<Int, String>,
        val fourth: Pair<Int, String>,
    )


    private var currentModelIndex = 0
    var sum = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val testModels = listOf<Item>(
            Item(
                Pair(1, requireContext().getString(R.string.one_answer_first)),
                Pair(2, requireContext().getString(R.string.one_answer_second)),
                Pair(3, requireContext().getString(R.string.one_answer_third)),
                Pair(4, requireContext().getString(R.string.one_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.two_answer_first)),
                Pair(2, requireContext().getString(R.string.two_answer_second)),
                Pair(3, requireContext().getString(R.string.two_answer_third)),
                Pair(4, requireContext().getString(R.string.two_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.three_answer_first)),
                Pair(2, requireContext().getString(R.string.three_answer_second)),
                Pair(3, requireContext().getString(R.string.three_answer_third)),
                Pair(4, requireContext().getString(R.string.three_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.four_answer_first)),
                Pair(2, requireContext().getString(R.string.four_answer_second)),
                Pair(3, requireContext().getString(R.string.four_answer_third)),
                Pair(4, requireContext().getString(R.string.four_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.five_answer_first)),
                Pair(2, requireContext().getString(R.string.five_answer_second)),
                Pair(3, requireContext().getString(R.string.five_answer_third)),
                Pair(4, requireContext().getString(R.string.five_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.six_answer_first)),
                Pair(2, requireContext().getString(R.string.six_answer_second)),
                Pair(3, requireContext().getString(R.string.six_answer_third)),
                Pair(4, requireContext().getString(R.string.six_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.seven_answer_first)),
                Pair(2, requireContext().getString(R.string.seven_answer_second)),
                Pair(3, requireContext().getString(R.string.seven_answer_third)),
                Pair(4, requireContext().getString(R.string.seven_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.eight_answer_first)),
                Pair(2, requireContext().getString(R.string.eight_answer_second)),
                Pair(3, requireContext().getString(R.string.eight_answer_third)),
                Pair(4, requireContext().getString(R.string.eight_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.nine_answer_first)),
                Pair(2, requireContext().getString(R.string.nine_answer_second)),
                Pair(3, requireContext().getString(R.string.nine_answer_third)),
                Pair(4, requireContext().getString(R.string.nine_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.ten_answer_first)),
                Pair(2, requireContext().getString(R.string.ten_answer_second)),
                Pair(3, requireContext().getString(R.string.ten_answer_third)),
                Pair(4, requireContext().getString(R.string.ten_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.eleven_answer_first)),
                Pair(2, requireContext().getString(R.string.eleven_answer_second)),
                Pair(3, requireContext().getString(R.string.eleven_answer_third)),
                Pair(4, requireContext().getString(R.string.eleven_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.twelve_answer_first)),
                Pair(2, requireContext().getString(R.string.twelve_answer_second)),
                Pair(3, requireContext().getString(R.string.twelve_answer_third)),
                Pair(4, requireContext().getString(R.string.twelve_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.thirteen_answer_first)),
                Pair(2, requireContext().getString(R.string.thirteen_answer_second)),
                Pair(3, requireContext().getString(R.string.thirteen_answer_third)),
                Pair(4, requireContext().getString(R.string.thirteen_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.fourteen_answer_first)),
                Pair(2, requireContext().getString(R.string.fourteen_answer_second)),
                Pair(3, requireContext().getString(R.string.fourteen_answer_third)),
                Pair(4, requireContext().getString(R.string.fourteen_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.fifteen_answer_first)),
                Pair(2, requireContext().getString(R.string.fifteen_answer_second)),
                Pair(3, requireContext().getString(R.string.fifteen_answer_third)),
                Pair(4, requireContext().getString(R.string.fifteen_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.sixteen_answer_first)),
                Pair(2, requireContext().getString(R.string.sixteen_answer_second)),
                Pair(3, requireContext().getString(R.string.sixteen_answer_third)),
                Pair(4, requireContext().getString(R.string.sixteen_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.seventeen_answer_first)),
                Pair(2, requireContext().getString(R.string.seventeen_answer_second)),
                Pair(3, requireContext().getString(R.string.seventeen_answer_third)),
                Pair(4, requireContext().getString(R.string.seventeen_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.eighteen_answer_first)),
                Pair(2, requireContext().getString(R.string.eighteen_answer_second)),
                Pair(3, requireContext().getString(R.string.eighteen_answer_third)),
                Pair(4, requireContext().getString(R.string.eighteen_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.nineteen_answer_first)),
                Pair(2, requireContext().getString(R.string.nineteen_answer_second)),
                Pair(3, requireContext().getString(R.string.nineteen_answer_third)),
                Pair(4, requireContext().getString(R.string.nineteen_answer_fourth))
            ),
            Item(
                Pair(1, requireContext().getString(R.string.twenty_answer_first)),
                Pair(2, requireContext().getString(R.string.twenty_answer_second)),
                Pair(3, requireContext().getString(R.string.twenty_answer_third)),
                Pair(4, requireContext().getString(R.string.twenty_answer_fourth))
            ),
        )


        // Set up the initial model
        setModel(testModels[currentModelIndex])
        binding.textviewFirst.text = "${currentModelIndex + 2} / ${testModels.size}"

        binding.buttonFirst.setOnClickListener {
            binding.apply {

                textviewFirst.text = "${currentModelIndex + 2} / ${testModels.size}"

                when (rbGroup.checkedRadioButtonId) {
                    R.id.rb_first -> {
                        rbFirst.text = testModels[currentModelIndex].first.second
                        sum += 1
                    }
                    R.id.rb_second -> {
                        rbSecond.text = testModels[currentModelIndex].second.second
                        sum += 2
                    }
                    R.id.rb_third -> {
                        rbThird.text = testModels[currentModelIndex].third.second
                        sum += 3
                    }
                    R.id.rb_fourth -> {
                        rbFourth.text = testModels[currentModelIndex].fourth.second
                        sum += 4
                    }
                }

                // switch to the next model or finish the test
                if (currentModelIndex < testModels.size - 1) {
                    currentModelIndex++
                    binding.buttonFirst.text = "Next"
                    setModel(testModels[currentModelIndex])
                } else {
                    finishTest()
                    binding.buttonFirst.text = "Finish"
                }
            }
        }
    }

    // Sets up the UI with the current model
    private fun setModel(model: Item) {
        binding.apply {
            rbFirst.text = model.first.second
            rbSecond.text = model.second.second
            rbThird.text = model.third.second
            rbFourth.text = model.fourth.second
            rbGroup.clearCheck()
        }
    }

    // Finish the test and show the results
    private fun finishTest() {
        // perform the necessary actions to finish the test and show the results
        binding.buttonFirst.setOnClickListener {
            val bundle = Bundle().putSerializable("sum", sum)
            findNavController().navigate(R.id.action_testFragment_to_conclusionFragment, bundle)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}