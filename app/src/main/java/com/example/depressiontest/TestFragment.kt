package com.example.depressiontest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.depressiontest.databinding.FragmentTestBinding
import com.google.android.material.snackbar.Snackbar


class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

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
    private var sum = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val testModels = listOf(
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
            )
        )


        // Set up the initial model
        setModel(testModels[currentModelIndex])
        binding.tvNumber.text = requireContext().getString(
            R.string.number,
            currentModelIndex + 1,
            testModels.size
        )//"${currentModelIndex + 1} / ${testModels.size}"


        binding.btnNext.setOnClickListener {
            currentModelIndex++
            binding.apply {

                val checked =
                    rbFirst.isChecked || rbSecond.isChecked || rbThird.isChecked || rbFourth.isChecked


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
                if (checked) {
                    if (currentModelIndex < testModels.size - 1) {
                        // If there are more questions, move to the next one
                        //binding.btnNext.text = requireContext().getString(R.string.next)
                        tvNumber.text = requireContext().getString(
                            R.string.number,
                            currentModelIndex + 1,
                            testModels.size
                        )
                        setModel(testModels[currentModelIndex])
                    } else {
                        // If this is the last question, finish the test
                        setModel(testModels[currentModelIndex])
                        tvNumber.text = requireContext().getString(
                            R.string.number,
                            currentModelIndex + 1,
                            testModels.size
                        )
                        binding.btnNext.visibility = View.GONE
                        binding.btnFinish.visibility = View.VISIBLE
                        finishTest()
                    }
                } else {
                    Snackbar.make(
                        requireContext(),
                        requireView(),
                        "You have not selected anything",
                        Snackbar.LENGTH_SHORT
                    ).show()
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
        binding.btnFinish.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("sum", sum)
            }
            findNavController().navigate(R.id.action_testFragment_to_conclusionFragment, bundle)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}