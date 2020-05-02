package com.souptik.maiti.demonationalsystem.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.souptik.maiti.demonationalsystem.R
import com.souptik.maiti.demonationalsystem.data.ResponseDataXX
import kotlinx.android.synthetic.main.similar_layout.view.*

class SimilarItemAdapter(val itemList: ArrayList<ResponseDataXX>): RecyclerView.Adapter<SimilarItemAdapter.SimilarViewHolder>() {

    class SimilarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(responseDataXX: ResponseDataXX){
            Glide.with(itemView).load(responseDataXX.image_link).into(itemView.iv_product)
            itemView.tv_price.text = "Rs: " + responseDataXX.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        return SimilarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.similar_layout, parent, false))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun appendData(dataList: List<ResponseDataXX>){
        this.itemList.addAll(dataList)
        notifyDataSetChanged()
    }
}