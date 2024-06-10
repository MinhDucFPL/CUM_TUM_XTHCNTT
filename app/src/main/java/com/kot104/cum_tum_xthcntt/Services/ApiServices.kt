package com.kot104.cum_tum_xthcntt.Services

import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import com.kot104.cum_tum_xthcntt.Model.MonAn
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiServices {
    @POST("themLoaiMon")
    suspend fun themLoaiMon(@Body category: LoaiMonAn): Response<LoaiMonAn>

    @PUT("suaLoaiMon/{id}")
    suspend fun suaLoaiMon(@Path("id") id: String, @Body category: LoaiMonAn): Response<LoaiMonAn>

    @DELETE("xoaLoaiMon/{id}")
    suspend fun xoaLoaiMon(@Path("id") id: String): Response<LoaiMonAn>

    @GET("layDanhSachLoaiMon")
    suspend fun layDanhSachLoaiMon(): Response<List<LoaiMonAn>>

    @Multipart
    @POST("themMonAn")
    suspend fun themMonAn(@Part hinhAnh: MultipartBody.Part,
                          @Part("tenMon") tenMon: RequestBody,
                          @Part("giaMon") giaMon: RequestBody,
                          @Part("id_loaiMonAn") id_loaiMonAn: RequestBody): Response<MonAn>

    @Multipart
    @PUT("suaMonAn/{id}")
    suspend fun suaMonAn(@Path("id") id: String,
                        @Part hinhAnh: MultipartBody.Part,
                         @Part("tenMon") tenMon: RequestBody,
                         @Part("giaMon") giaMon: RequestBody,
                         @Part("id_loaiMonAn") id_loaiMonAn: RequestBody): Response<MonAn>

    @DELETE("xoaMonAn/{id}")
    suspend fun xoaMonAn(@Path("id") id: String): Response<MonAn>

    @GET("layDanhSachMonAn")
    suspend fun layDanhSachMonAn(): Response<List<MonAn>>
}