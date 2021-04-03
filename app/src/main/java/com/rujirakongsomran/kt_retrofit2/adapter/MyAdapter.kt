package com.rujirakongsomran.kt_retrofit2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rujirakongsomran.kt_retrofit2.R
import com.rujirakongsomran.kt_retrofit2.databinding.ActivityMainBinding
import com.rujirakongsomran.kt_retrofit2.databinding.RowLayoutBinding
import com.rujirakongsomran.kt_retrofit2.model.Post

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    class MyViewHolder(
        val binding: RowLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val binding = RowLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvUserId.text = myList[position].userId.toString()
        holder.binding.tvId.text = myList[position].id.toString()
        holder.binding.tvTitle.text = myList[position].title.toString()
        holder.binding.tvBody.text = myList[position].body.toString()
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Post>) {
        myList = newList
        notifyDataSetChanged()
    }
}