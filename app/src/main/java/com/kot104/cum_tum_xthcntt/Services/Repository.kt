package com.kot104.cum_tum_xthcntt.Services

import android.util.Log
import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import com.kot104.cum_tum_xthcntt.Model.MonAn
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class Repository {
    private val apiService = RetrofitService().apiService

    suspend fun themLoaiMon(category: LoaiMonAn): LoaiMonAn? {
        return try {
            val response = apiService.themLoaiMon(category)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Thêm loại món thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi thêm loại món", e)
            null
        }
    }

    suspend fun suaLoaiMon(id: String, category: LoaiMonAn): LoaiMonAn? {
        return try {
            val response = apiService.suaLoaiMon(id, category)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Sửa loại món thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi sửa loại món", e)
            null
        }
    }

    suspend fun xoaLoaiMon(id: String): LoaiMonAn? {
        return try {
            val response = apiService.xoaLoaiMon(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Xóa loại món thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi xóa loại món", e)
            null
        }
    }

    suspend fun layDanhSachLoaiMon(): List<LoaiMonAn>? {
        return try {
            val response = apiService.layDanhSachLoaiMon()
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Lấy danh sách loại món thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi lấy danh sách loại món", e)
            null
        }
    }

    suspend fun themMonAn(name: String, price: String, categoryId: String, imageFile: File): MonAn? {
        return try {
            val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), imageFile)
            val body = MultipartBody.Part.createFormData("hinhAnh", imageFile.name, requestFile)
            val namePart = RequestBody.create("text/plain".toMediaTypeOrNull(), name)
            val pricePart = RequestBody.create("text/plain".toMediaTypeOrNull(), price)
            val categoryIdPart = RequestBody.create("text/plain".toMediaTypeOrNull(), categoryId)

            val response = apiService.themMonAn(body, namePart, pricePart, categoryIdPart)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Thêm món ăn thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi thêm món ăn", e)
            null
        }
    }

    suspend fun suaMonAn(id: String, name: String, price: String, categoryId: String, imageFile: File?): MonAn? {
        return try {
            val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), imageFile!!)
            val body = MultipartBody.Part.createFormData("hinhAnh", imageFile.name, requestFile)
            val namePart = RequestBody.create("text/plain".toMediaTypeOrNull(), name)
            val pricePart = RequestBody.create("text/plain".toMediaTypeOrNull(), price)
            val categoryIdPart = RequestBody.create("text/plain".toMediaTypeOrNull(), categoryId)

            val response = apiService.suaMonAn(id, body, namePart, pricePart, categoryIdPart)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Sửa món ăn thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi sửa món ăn", e)
            null
        }
    }

    suspend fun xoaMonAn(id: String): MonAn? {
        return try {
            val response = apiService.xoaMonAn(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Xóa món ăn thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi xóa món ăn", e)
            null
        }
    }

    suspend fun layDanhSachMonAn(): List<MonAn>? {
        return try {
            val response = apiService.layDanhSachMonAn()
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("Repository", "Lấy danh sách món ăn thất bại: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Ngoại lệ khi lấy danh sách món ăn", e)
            null
        }
    }
}