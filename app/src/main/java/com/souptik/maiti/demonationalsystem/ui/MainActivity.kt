package com.souptik.maiti.demonationalsystem.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.souptik.maiti.demonationalsystem.BuildConfig
import com.souptik.maiti.demonationalsystem.R
import com.souptik.maiti.demonationalsystem.data.ItemResponse
import com.souptik.maiti.demonationalsystem.data.ResponseData
import com.souptik.maiti.demonationalsystem.remote.Networking
import com.souptik.maiti.demonationalsystem.remote.NetworkService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), ItemListener {

    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_items.layoutManager = LinearLayoutManager(this@MainActivity)
        itemAdapter = ItemAdapter(ArrayList())
        itemAdapter.setListener(this)
        rv_items.adapter =itemAdapter
        callRetrofit()

    }

    private fun callRetrofit(){
        val networkService: NetworkService = Networking.create(baseUrl = BuildConfig.BASE_URL,
                cacheDir = application.cacheDir,
                cacheSize = 10 * 1024 * 1024 // 10MB
        )

        networkService.getItemResponse(9546004400, 6, "")
                .enqueue(object: retrofit2.Callback<ItemResponse> {
                    override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                        val itemResponse: ItemResponse = response.body() as ItemResponse
                        itemAdapter.appendData(itemResponse.responseList)
                        itemAdapter.notifyDataSetChanged()

                    }

                })
    }

    override fun itemClick(responseData: ResponseData) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("Details", responseData)
        startActivity(intent)
    }
}
