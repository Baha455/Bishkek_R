package com.example.bishkekrielt.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bishkekrielt.data.model.Recatalog
import com.example.bishkekrielt.databinding.RecyclerViewBinding
import com.example.bishkekrielt.ui.home.HomeViewModel


class RvAdapter(private val vm: HomeViewModel) : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    var items1 = arrayListOf<Recatalog>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding, vm)
    }

    fun updateData(list: List<Recatalog>){
            this.items1.clear()
            this.items1.addAll(list)
            notifyDataSetChanged()


    }

    override fun getItemCount(): Int {
       return items1.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items1[position])

    }

    class MyViewHolder(
    private val binding: RecyclerViewBinding,
    private val vm: HomeViewModel
    ): RecyclerView.ViewHolder(binding.root){


        fun bind(recatalog: Recatalog){
            binding.title.text = recatalog.price
            binding.description.text = recatalog.title
        }
    }
}