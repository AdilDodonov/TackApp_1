package com.example.tackapp_1.ui.onBoard

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.tackapp_1.R
import com.example.tackapp_1.Utils.Preferencas
import com.example.tackapp_1.databinding.FragmentOnBoardPageBinding


class OnBoardPageFragment(var listenerSkip: () -> Unit, var listenerNext: () -> Unit) : Fragment() {

    private lateinit var binding: FragmentOnBoardPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPageBinding.inflate(inflater, container, false)
        initViews()
        initListners()
        return binding.root
    }

    private fun initViews() {
        val data = arguments?.getSerializable("onBoard") as BoardModel
        data.image?.let { binding.img1.setImageResource(it) }
        binding.tvList.text = data.title
        binding.tvDescBoard.text = data.desc

        binding.btnSkip.isVisible = data.isLast == false
        binding.btnNext.isVisible = data.isLast == false

        binding.btnStart.isVisible = data.isLast == true

    }

    private fun initListners() {

        binding.btnStart.setOnClickListener {
            findNavController().navigateUp()
            Preferencas(requireContext()).setBoardingShowed(true)
            Preferencas(requireContext()).board =true

        }

        binding.btnSkip.setOnClickListener {
            listenerSkip.invoke()
        }
        binding.btnNext.setOnClickListener {
            listenerNext.invoke()
        }
    }
}