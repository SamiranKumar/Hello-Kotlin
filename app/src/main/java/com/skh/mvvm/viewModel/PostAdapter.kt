package com.skh.mvvm.viewModel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.mvvm.databinding.RowItemBinding
import com.skh.mvvm.model.ResponsePost


/**
Created by Samiran Kumar on 20,September,2022
 **/
class PostAdapter(private var postList: List<ResponsePost> = ArrayList())
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private lateinit var binding:RowItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = RowItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tasks.text=postList[position].body
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    fun setData(postList: List<ResponsePost>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }

}