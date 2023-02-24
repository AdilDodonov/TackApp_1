package com.example.tackapp_1.ui.onBoard

import android.graphics.pdf.PdfDocument.Page
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tackapp_1.R
import com.example.tackapp_1.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {


    private  lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        initViews()
        initListners()
        return binding.root
    }

    private fun initListners() {

    }

    private fun initViews() {
        val adapter=  BoardAdapter(childFragmentManager, this :: onSkipKlick, this::onNextKlick)
        binding.vpBoard.adapter = adapter
        binding.springDotsIndicator.attachTo(binding.vpBoard)
    }
    private fun onSkipKlick(){
        binding.vpBoard.currentItem = 2
    }

    private  fun  onNextKlick(){
        binding.vpBoard.currentItem += 1
    }


}