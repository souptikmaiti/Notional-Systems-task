package com.souptik.maiti.demonationalsystem.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.souptik.maiti.demonationalsystem.R
import com.souptik.maiti.demonationalsystem.data.ResponseData
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemAdapter (val itemList: ArrayList<ResponseData> ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    lateinit var itemListener: ItemListener

    fun setListener(itemListener: ItemListener){
        this.itemListener = itemListener
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(responseData: ResponseData){
            Glide.with(itemView).load(responseData.image_link).into(itemView.iv_product)
            itemView.tv_title.text = responseData.title
            itemView.tv_price.text = "Rs: " + responseData.price
            if(responseData.added_in_wishlist){
                Glide.with(itemView).load(R.drawable.ic_thumb_up).into(itemView.iv_like_unlike)
            }else{
                Glide.with(itemView).load(R.drawable.ic_thumb_down).into(itemView.iv_like_unlike)
            }

            itemView.card_root.setOnClickListener {
                itemListener.itemClick(responseData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int = itemList.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun appendData(dataList: List<ResponseData>){
        this.itemList.addAll(dataList)
        notifyDataSetChanged()
    }
}