package com.kot104.cum_tum_xthcntt.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import com.kot104.cum_tum_xthcntt.Services.Repository

import kotlinx.coroutines.launch

class LoaiMonAnViewModel : ViewModel() {
    private val repository = Repository()

    fun themLoaiMon (category: LoaiMonAn, onResult: (LoaiMonAn?) -> Unit) {
        viewModelScope.launch {
            repository.themLoaiMon(category) {
                onResult(it)
            }
        }
    }

    fun suaLoaiMon(id: String, category: LoaiMonAn, onResult: (LoaiMonAn?) -> Unit) {
        viewModelScope.launch {
            repository.suaLoaiMon(id, category) {
                onResult(it)
            }
        }
    }

    fun xoaLoaiMon(id: String, onResult: (LoaiMonAn?) -> Unit) {
        viewModelScope.launch {
            repository.xoaLoaiMon(id) {
                onResult(it)
            }
        }
    }

    fun layDanhSachLoaiMon(onResult: (List<LoaiMonAn>?) -> Unit) {
        viewModelScope.launch {
            repository.layDanhSachLoaiMon {
                onResult(it)
            }
        }
    }
}