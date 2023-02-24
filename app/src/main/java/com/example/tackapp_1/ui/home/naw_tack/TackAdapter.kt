package com.example.tackapp_1.ui.home.naw_tack

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tackapp_1.databinding.TackIremBinding

class TackAdapter : RecyclerView.Adapter<TackAdapter.TackHolder>() {

    private var taskList = arrayListOf<TackModel>()
    fun addTask(taskModel: TackModel){
        taskList.add(taskModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TackHolder {
        return TackHolder(TackIremBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TackHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    inner class TackHolder (private var binding: TackIremBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tackModel: TackModel) {
            binding.tvTitleItem.text = tackModel.title
            binding.tvDescItem.text = tackModel.desc
        }
    }
}