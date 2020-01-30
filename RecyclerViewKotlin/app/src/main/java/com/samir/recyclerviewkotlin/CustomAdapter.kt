package com.samir.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val context: Context,
    internal var list: ArrayList<User> // ArrayList of your Data Model
)// you can pass other parameters in constructor
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal val VIEW_TYPE_ONE = 1
    internal val VIEW_TYPE_TWO = 2

    private inner class ViewHolder1  constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        internal var tvUserName: TextView
        internal var tvAddress: TextView

        init {
            tvUserName = itemView.findViewById(R.id.tvUserName)
            tvAddress = itemView.findViewById(R.id.tvAddress)
        }

        internal fun bind(position: Int) {

            tvUserName.text = list[position].name
            tvAddress.text = list[position].address
        }


        fun bindView(user: User) {

        }

    }

    private inner class ViewHolder2 internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        internal var tvUserName: TextView
        internal var tvAddress: TextView

        init {
            tvUserName =
                itemView.findViewById(R.id.tvUserName) // Initialize your All views prensent in list items
            tvAddress =
                itemView.findViewById(R.id.tvAddress) // Initialize your All views prensent in list items
        }

        internal fun bind(position: Int) {
            tvUserName.text = list[position].name
            tvAddress.text = list[position].address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE) {
            ViewHolder1(LayoutInflater.from(context).inflate(R.layout.row_item, parent, false))
        } else ViewHolder2(
            LayoutInflater.from(context).inflate(
                R.layout.row_item,
                parent,
                false
            )
        ) //if it's not VIEW_TYPE_ONE then its VIEW_TYPE_TWO
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].type == VIEW_TYPE_ONE) { // put your condition, according to your requirements
            (holder as ViewHolder1).bind(position)
        } else {
            (holder as ViewHolder2).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {

        return if (list[position].type === VIEW_TYPE_TWO) { // put your condition, according to your requirements
            VIEW_TYPE_ONE
        } else VIEW_TYPE_TWO
    }
}