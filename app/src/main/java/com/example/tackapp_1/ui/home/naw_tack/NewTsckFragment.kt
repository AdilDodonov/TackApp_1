package com.example.tackapp_1.ui.home.naw_tack

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.tackapp_1.R
import com.example.tackapp_1.databinding.FragmentNewTsckBinding

class NewTsckFragment : Fragment() {

    private lateinit var binding: FragmentNewTsckBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTsckBinding.inflate(inflater, container, false)
        initViews()
        initListner()
        return binding.root
    }

    private fun initListner() {
        binding.btnSave.setOnClickListener {
            setFragmentResult(
                TACK_KEY, bundleOf(
                    "title" to binding.etTextTitle.text.toString(),
                    "deccpition" to binding.etTextDecrpition.text.toString()
                )
            )
            findNavController().navigateUp()
        }
    }

    private fun initViews() {
    }

    companion object {
        const val TACK_KEY = " new_tack"
    }
}