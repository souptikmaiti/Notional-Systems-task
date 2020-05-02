package com.souptik.maiti.demonationalsystem.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.souptik.maiti.demonationalsystem.R
import com.souptik.maiti.demonationalsystem.data.StylePick
import kotlinx.android.synthetic.main.details_layout.view.*

class DetailsAdapter (val itemList: ArrayList<StylePick> ): RecyclerView.Adapter<DetailsAdapter.DetailViewHolder>() {


    class DetailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(stylePick: StylePick){
            Glide.with(itemView).load(stylePick.image_link).into(itemView.iv_product)
            itemView.tv_price.text = "Rs: " + stylePick.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.details_layout, parent, false))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun appendData(dataList: List<StylePick>){
        this.itemList.addAll(dataList)
        notifyDataSetChanged()
    }
}