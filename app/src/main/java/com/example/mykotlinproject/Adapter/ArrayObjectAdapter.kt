package com.example.mykotlinproject.Adapter


import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.array_itm.view.*
import com.example.mykotlinproject.ModelClass.ArrayObjectPojo


class ArrayObjectAdapter(val items: ArrayList<ArrayObjectPojo>, val context: Context) : RecyclerView.Adapter<ArrayObjectAdapter.ViewHolder>() {
    // Inflates the item views

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(com.example.mykotlinproject.R.layout.array_itm, parent, false))

    }
    // Binds each animal in the ArrayList to a view

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Tv_user_id?.text = items.get(position).userId.toString()
        holder.Tv_id?.text = items.get(position).id.toString()
        holder.Tv_user_title?.text = items.get(position).title

        //gone
        holder.LL_parent.visibility = View.VISIBLE

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val Tv_user_id = view.Tv_user_id
        val Tv_id = view.Tv_id
        val Tv_user_title = view.Tv_user_title
        var LL_parent=view.LL_parent
    }
}



