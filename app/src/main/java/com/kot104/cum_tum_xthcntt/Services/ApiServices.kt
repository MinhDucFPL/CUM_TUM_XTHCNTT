package com.kot104.cum_tum_xthcntt.Services

import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServices {
    @POST("themLoaiMon")
    fun themLoaiMon(@Body category: LoaiMonAn): Call<LoaiMonAn>
    @PUT("suaLoaiMon/{id}")
    fun suaLoaiMon(@Path("id") id: String, @Body category: LoaiMonAn): Call<LoaiMonAn>

    @DELETE("xoaLoaiMon/{id}")
    fun xoaLoaiMon(@Path("id") id: String): Call<LoaiMonAn>

    @GET("layDanhSachLoaiMon")
    fun layDanhSachLoaiMon(): Call<List<LoaiMonAn>>
}