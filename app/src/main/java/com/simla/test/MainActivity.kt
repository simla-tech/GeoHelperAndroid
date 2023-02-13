package com.simla.test

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.simla.geohelper.GeoHelper
import com.simla.geohelper.GeoHelperConfig
import com.simla.geohelper.model.params.PaginationParam
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(this).build())
            .build()

        val geoHelper = GeoHelper(
            GeoHelperConfig.Builder(apiKey = "TpUN9HmsxxhDutK6hwwpSeWWDjsG294F")
                .httpClient(httpClient)
                .build()
        )

        findViewById<Button>(R.id.btn_run).setOnClickListener {
            lifecycleScope.launch(CoroutineExceptionHandler { _, throwable ->
                println(throwable)
            }) {
                val response = geoHelper.api.cities(
                    pagination = PaginationParam.Builder().limit(100).build()
                )
                println(response.result)
            }
        }
    }
}