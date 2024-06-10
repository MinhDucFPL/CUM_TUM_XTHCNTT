package com.kot104.cum_tum_xthcntt.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import com.kot104.cum_tum_xthcntt.Services.Repository

import kotlinx.coroutines.launch

class LoaiMonAnViewModel : ViewModel() {

    private val repository = Repository()

    private val _categories = MutableLiveData<List<LoaiMonAn>>()
    val categories: LiveData<List<LoaiMonAn>> = _categories

    init {
        layDanhSachLoaiMonAn()
    }

    private fun layDanhSachLoaiMonAn() {
        viewModelScope.launch {
            val result = repository.layDanhSachLoaiMon()
            _categories.postValue(result ?: emptyList())
        }
    }

    fun refreshLoaiMonAnList() {
        viewModelScope.launch {
            val result = repository.layDanhSachLoaiMon()
            _categories.postValue(result ?: emptyList())
        }
    }

    fun themLoaiMon(category: LoaiMonAn) {
        viewModelScope.launch {
            val result = repository.themLoaiMon(category)
            if (result != null) {
                val updatedList = _categories.value?.toMutableList() ?: mutableListOf()
                updatedList.add(result)
                _categories.value = updatedList
                layDanhSachLoaiMonAn()
            }
        }
    }

    fun suaLoaiMon(id: String, category: LoaiMonAn) {
        viewModelScope.launch {
            val result = repository.suaLoaiMon(id, category)
            if (result != null) {
                val updatedList = _categories.value?.toMutableList() ?: mutableListOf()
                val index = updatedList.indexOfFirst { it._id == id }
                if (index != -1) {
                    updatedList[index] = result
                    _categories.value = updatedList
                    layDanhSachLoaiMonAn()
                }
            }
        }
    }

    fun xoaLoaiMon(id: String) {
        viewModelScope.launch {
            val result = repository.xoaLoaiMon(id)
            if (result != null) {
                val updatedList = _categories.value?.toMutableList() ?: mutableListOf()
                updatedList.removeAll { it._id == id }
                _categories.value = updatedList
                layDanhSachLoaiMonAn()
            }
        }
    }
}