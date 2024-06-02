package com.kot104.cum_tum_xthcntt.ui.theme

sealed class  Screens(val screen: String){
    data object Home : Screens("home")
    data object Statistical : Screens("statistical")
    data object Manage : Screens("manage")
    data object Support : Screens("support")
}