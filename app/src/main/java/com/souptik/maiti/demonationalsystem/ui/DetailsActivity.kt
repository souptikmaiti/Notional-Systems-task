package com.souptik.maiti.demonationalsystem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.souptik.maiti.demonationalsystem.BuildConfig
import com.souptik.maiti.demonationalsystem.R
import com.souptik.maiti.demonationalsystem.data.ItemDetails
import com.souptik.maiti.demonationalsystem.data.ResponseData
import com.souptik.maiti.demonationalsystem.data.SimilarProducts
import com.souptik.maiti.demonationalsystem.remote.NetworkService
import com.souptik.maiti.demonationalsystem.remote.Networking
import kotlinx.android.synthetic.main.activity_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {

    lateinit var detailsAdapter: DetailsAdapter
    lateinit var similarAdapter: SimilarItemAdapter
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var responseData: ResponseData = intent.getSerializableExtra("Details") as ResponseData

        detailsAdapter = DetailsAdapter(ArrayList())
        rv_details.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_details.adapter = detailsAdapter

        similarAdapter = SimilarItemAdapter(ArrayList())
        rv_similar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_similar.adapter = similarAdapter

        getNetworkService()
        callRetrofitDetails(responseData.product_id.toInt(), responseData.sku_code)
        callRetrofitSimilar(responseData.product_id.toInt(), responseData.sku_code)


    }

    private fun getNetworkService(){
        networkService = Networking.create(baseUrl = BuildConfig.BASE_URL,
            cacheDir = application.cacheDir,
            cacheSize = 10 * 1024 * 1024 // 10MB
        )
    }



    private fun callRetrofitDetails(id:Int, sku:String){
        networkService.getItemDetails(9546004400, id, sku)
            .enqueue(object: retrofit2.Callback<ItemDetails> {
                override fun onFailure(call: Call<ItemDetails>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(call: Call<ItemDetails>, response: Response<ItemDetails>) {
                    val itemDetails: ItemDetails = response.body() as ItemDetails
                    detailsAdapter.appendData(itemDetails.ResponseData.style_picks)

                }

            })
    }

    private fun callRetrofitSimilar(id: Int, sku: String){
        networkService.getSimilarProducts(9546004400, id, sku)
            .enqueue(object: Callback<SimilarProducts>{
                override fun onFailure(call: Call<SimilarProducts>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<SimilarProducts>,
                    response: Response<SimilarProducts>
                ) {
                    val similarProducts: SimilarProducts = response.body() as SimilarProducts
                    similarAdapter.appendData(similarProducts.ResponseData)
                }

            })
    }
}
