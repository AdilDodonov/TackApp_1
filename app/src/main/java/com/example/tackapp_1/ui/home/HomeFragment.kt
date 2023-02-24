package com.example.tackapp_1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tackapp_1.R
import com.example.tackapp_1.databinding.FragmentHomeBinding
import com.example.tackapp_1.ui.home.naw_tack.NewTsckFragment
import com.example.tackapp_1.ui.home.naw_tack.NewTsckFragment.Companion.TACK_KEY
import com.example.tackapp_1.ui.home.naw_tack.TackAdapter
import com.example.tackapp_1.ui.home.naw_tack.TackModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var taskAdapter: TackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initViews()
        initListner()
        return binding.root
    }

    private fun initListner() {
        binding.fabhome.setOnClickListener{
            findNavController().navigate(R.id.navigation_new_tack)
        }
    }
    private fun initViews() {

        binding.rvHome.layoutManager = LinearLayoutManager(context)
        binding.rvHome.adapter = taskAdapter

        setFragmentResultListener(TACK_KEY,) { _,bundle ->
            Log.e("ololo", "initViews:" + bundle. getString("title") + bundle.getString("deccpition"))
            val title = bundle.getString("title")
            val desc = bundle.getString("deccpition")
            taskAdapter.addTask(TackModel(
                title, desc
            ))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskAdapter = TackAdapter()
    }


}