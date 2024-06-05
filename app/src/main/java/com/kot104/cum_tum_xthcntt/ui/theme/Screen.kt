package com.kot104.cum_tum_xthcntt.ui.theme

sealed class Screens(val screen: String){
    data object ManChao : Screens("ManChao")
    data object DangNhap : Screens("DangNhap")
    data object TrangChu : Screens("TrangChu")
    data object ThongKe : Screens("ThongKe")
    data object QuanLy : Screens("QuanLy")
    data object HoTro : Screens("HoTro")
    data object QuanLyMonAn : Screens("QuanLyMonAn")
    data object QuanLyLoaiMonAn : Screens("QuanLyLoaiMonAn")
    data object ThemMonAn : Screens("ThemMonAn")
    data object SuaMonAn : Screens("SuaMonAn")
    data object DanhSachSuaMonAn : Screens("DanhSachSuaMonAn")
    data object XoaMonAn : Screens("XoaMonAn")
    data object ThemLoaiMonAn : Screens("ThemLoaiMonAn")
    data object SuaLoaiMonAn : Screens("SuaLoaiMonAn")
    data object XoaLoaiMonAn : Screens("XoaLoaiMonAn")
}