package com.kot104.cum_tum_xthcntt.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kot104.cum_tum_xthcntt.Model.MonAn
import com.kot104.cum_tum_xthcntt.Services.Repository
import kotlinx.coroutines.launch
import java.io.File

class MonAnViewModel : ViewModel() {
    private val repository = Repository()

    private val _dishes = MutableLiveData<List<MonAn>>()
    val dishes: LiveData<List<MonAn>> = _dishes

    init {
        layDanhSachMonAn()
    }

    private fun layDanhSachMonAn() {
        viewModelScope.launch {
            val result = repository.layDanhSachMonAn()
            _dishes.postValue(result ?: emptyList())
        }
    }

    fun refreshDanhSachMonAn() {
        viewModelScope.launch {
            val result = repository.layDanhSachMonAn()
            _dishes.postValue(result ?: emptyList())
        }
    }

    fun themMonAn(name: String, price: String, categoryId: String, imageFile: File, onComplete: (MonAn?) -> Unit) {
        viewModelScope.launch {
            val result = repository.themMonAn(name, price, categoryId, imageFile)
            onComplete(result)
            if (result != null) {
                val updatedList = _dishes.value?.toMutableList() ?: mutableListOf()
                updatedList.add(result)
                _dishes.value = updatedList
            }
        }
    }

    fun suaMonAn(id: String, name: String, price: String, categoryId: String, imageFile: File, onComplete: (MonAn?) -> Unit) {
        viewModelScope.launch {
            try {
                val result = repository.suaMonAn(id, name, price, categoryId, imageFile)
                onComplete(result)
                if (result != null) {
                    val updatedList = _dishes.value?.toMutableList() ?: mutableListOf()
                    val index = updatedList.indexOfFirst { it._id == id }
                    if (index >= 0) {
                        updatedList[index] = result
                        _dishes.value = updatedList
                    }
                }
            } catch (e: Exception) {
                Log.e("MonAnViewModel", "Lỗi khi sửa món ăn", e)
                onComplete(null)
            }
        }
    }

    fun xoaMonAn(id: String) {
        viewModelScope.launch {
            val result = repository.xoaMonAn(id)
            if (result != null) {
                val updatedList = _dishes.value?.toMutableList() ?: mutableListOf()
                updatedList.removeAll { it._id == id }
                _dishes.value = updatedList
                layDanhSachMonAn()
            }
        }
    }
}