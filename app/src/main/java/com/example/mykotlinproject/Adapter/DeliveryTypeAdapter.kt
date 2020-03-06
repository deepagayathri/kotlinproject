package com.example.mykotlinproject.Adapter


import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.array_itm.view.*
import com.example.mykotlinproject.ModelClass.ArrayObjectPojo
import com.example.mykotlinproject.ModelClass.DeliveryTypesItem
import com.example.mykotlinproject.ModelClass.ObjWithMultiPojo
import kotlinx.android.synthetic.main.delivery_item.view.*


class DeliveryTypeAdapter(val items: ArrayList<DeliveryTypesItem>, val context: Context) :
    RecyclerView.Adapter<DeliveryTypeAdapter.ViewHolder>() {
    // Inflates the item views

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                com.example.mykotlinproject.R.layout.delivery_item,
                parent,
                false
            )
        )

    }
    // Binds each animal in the ArrayList to a view

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Tv_delivery_id?.text = items.get(position).deliveryTypeId
        holder.Tv_delivery_type?.text = items.get(position).deliveryType


    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val Tv_delivery_id = view.Tv_delivery_id
        val Tv_delivery_type = view.Tv_delivery_type

    }

}
