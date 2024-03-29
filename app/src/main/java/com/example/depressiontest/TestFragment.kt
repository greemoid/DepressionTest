package com.example.depressiontest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
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


    private var currentModelIndex = 0
    private var sum = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Set up the initial model
        setModel(createTests()[currentModelIndex])
        binding.tvNumber.text = requireContext().getString(
            R.string.number,
            currentModelIndex + 1,
            createTests().size
        )


        startAnimation()
        binding.btnNext.setOnClickListener {
            currentModelIndex++
            binding.apply {

                val checked =
                    rbFirst.isChecked || rbSecond.isChecked || rbThird.isChecked || rbFourth.isChecked


                when (rbGroup.checkedRadioButtonId) {
                    R.id.rb_first -> {
                        rbFirst.text = createTests()[currentModelIndex].first.second
                        sum += 1
                    }

                    R.id.rb_second -> {
                        rbSecond.text = createTests()[currentModelIndex].second.second
                        sum += 2
                    }

                    R.id.rb_third -> {
                        rbThird.text = createTests()[currentModelIndex].third.second
                        sum += 3
                    }

                    R.id.rb_fourth -> {
                        rbFourth.text = createTests()[currentModelIndex].fourth.second
                        sum += 4
                    }
                }

                // switch to the next model or finish the test
                if (checked) {
                    if (currentModelIndex < createTests().size - 1) {
                        // If there are more questions, move to the next one
                        startAnimation()
                        tvNumber.text = requireContext().getString(
                            R.string.number,
                            currentModelIndex + 1,
                            createTests().size
                        )
                        setModel(createTests()[currentModelIndex])
                    } else {
                        // If this is the last question, finish the test
                        setModel(createTests()[currentModelIndex])
                        startAnimation()
                        tvNumber.text = requireContext().getString(
                            R.string.number,
                            currentModelIndex + 1,
                            createTests().size
                        )
                        binding.btnNext.text = requireContext().getString(R.string.finish)
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
        binding.btnNext.setOnClickListener {

            val bundle = Bundle().apply {
                putInt("sum", sum)
            }
            findNavController().navigate(R.id.action_testFragment_to_conclusionFragment, bundle)
        }
    }

    private fun startAnimation() {
        val animFirst = AnimationUtils.loadAnimation(requireContext(), R.anim.text_fade_in)
        val animSecond = AnimationUtils.loadAnimation(requireContext(), R.anim.text_fade_in)
        val animThird = AnimationUtils.loadAnimation(requireContext(), R.anim.text_fade_in)
        val animFourth = AnimationUtils.loadAnimation(requireContext(), R.anim.text_fade_in)

        binding.apply {
            rbFirst.startAnimation(animFirst)
            rbSecond.startAnimation(animSecond)
            rbThird.startAnimation(animThird)
            rbFourth.startAnimation(animFourth)
        }
    }

    fun createTests(): List<Item> {
        return listOf(
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}