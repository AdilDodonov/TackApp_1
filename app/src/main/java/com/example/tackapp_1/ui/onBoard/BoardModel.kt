package com.example.tackapp_1.ui.onBoard

data class BoardModel(
    var image: Int? = null,
    var title: String ? = null,
    var desc: String? = null,
    val isLast: Boolean? = false
): java.io.Serializable
