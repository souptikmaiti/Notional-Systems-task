package com.souptik.maiti.demonationalsystem.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ResponseData(
    @Expose
    @SerializedName("added_in_wishlist")
    val added_in_wishlist: Boolean,

    @Expose
    @SerializedName("brand_name")
    val brand_name: String,

    @Expose
    @SerializedName("image_link")
    val image_link: String,

    @Expose
    @SerializedName("material_code")
    val material_code: String,

    @Expose
    @SerializedName("price")
    val price: String,

    @Expose
    @SerializedName("product_id")
    val product_id: String,

    @Expose
    @SerializedName("selling_price")
    val selling_price: String,

    @Expose
    @SerializedName("short_description")
    val short_description: String,

    @Expose
    @SerializedName("sku_code")
    val sku_code: String,

    @Expose
    @SerializedName("title")
    val title: String
): Serializable