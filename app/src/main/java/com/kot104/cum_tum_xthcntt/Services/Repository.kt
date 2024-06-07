package com.kot104.cum_tum_xthcntt.Services

import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class Repository {
    private val apiService = RetrofitService().apiService

    fun themLoaiMon(category: LoaiMonAn, onResult: (LoaiMonAn?) -> Unit) {
        apiService.themLoaiMon(category).enqueue(object : Callback<LoaiMonAn> {
            override fun onResponse(call: Call<LoaiMonAn>, response: Response<LoaiMonAn>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<LoaiMonAn>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun suaLoaiMon(id: String, category: LoaiMonAn, onResult: (LoaiMonAn?) -> Unit) {
        apiService.suaLoaiMon(id, category).enqueue(object : Callback<LoaiMonAn> {
            override fun onResponse(call: Call<LoaiMonAn>, response: Response<LoaiMonAn>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<LoaiMonAn>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun xoaLoaiMon(id: String, onResult: (LoaiMonAn?) -> Unit) {
        apiService.xoaLoaiMon(id).enqueue(object : Callback<LoaiMonAn> {
            override fun onResponse(call: Call<LoaiMonAn>, response: Response<LoaiMonAn>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<LoaiMonAn>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun layDanhSachLoaiMon(onResult: (List<LoaiMonAn>?) -> Unit) {
        apiService.layDanhSachLoaiMon().enqueue(object : Callback<List<LoaiMonAn>> {
            override fun onResponse(call: Call<List<LoaiMonAn>>, response: Response<List<LoaiMonAn>>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<List<LoaiMonAn>>, t: Throwable) {
                onResult(null)
            }
        })
    }
}