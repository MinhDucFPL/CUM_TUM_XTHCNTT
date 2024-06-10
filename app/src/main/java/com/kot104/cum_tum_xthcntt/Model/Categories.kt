package com.kot104.cum_tum_xthcntt.Model

import androidx.compose.ui.graphics.vector.ImageVector

data class Categories (val id: Int, val name: String, val image: ImageVector, var isSelected: Boolean = false) {
}