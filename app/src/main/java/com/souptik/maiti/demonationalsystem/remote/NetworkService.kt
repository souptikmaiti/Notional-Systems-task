package com.souptik.maiti.demonationalsystem.remote

import com.souptik.maiti.demonationalsystem.data.ItemDetails
import com.souptik.maiti.demonationalsystem.data.ItemResponse
import com.souptik.maiti.demonationalsystem.data.SimilarProducts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("aymo_dev/apiv2/productList.php")
    fun getItemResponse(@Query("user_id") user_id:Long,
                        @Query("categoryID") categoryID: Int,
                        @Query("subcategoryID") subcategoryID: String): Call<ItemResponse>

    @GET("aymo_dev/apiv2/productDetails.php")
    fun getItemDetails(@Query("user_id") user_id:Long,
                        @Query("product_id") product_id: Int,
                        @Query("product_sku") product_sku: String): Call<ItemDetails>

    @GET("aymo_dev/apiv2/similarProductList.php")
    fun getSimilarProducts(@Query("user_id") user_id:Long,
                       @Query("product_id") product_id: Int,
                       @Query("product_sku") product_sku: String): Call<SimilarProducts>
}