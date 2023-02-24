package com.example.tackapp_1.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tackapp_1.R
import com.example.tackapp_1.databinding.ActivityMainBinding
import com.example.tackapp_1.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

var mGetContent:ActivityResultLauncher<String> = registerForActivityResult(
    ActivityResultContracts.GetContent()
){uri ->
    binding.imgProfile.setImageURI(uri)
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        initView()
        initListners()
        return binding.root
    }

    private fun initView() {


    }
    private fun initListners() {

        binding.imgProfile.setOnClickListener{
            mGetContent.launch("image/*")
        }
    }


}