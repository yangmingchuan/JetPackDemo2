package com.xmly.jetpackdemo2

/**
 *
 *
 * @author Yang mingchuan
 * @email mingchuan.yang@ximalaya.com
 * @phoneNumber 17621066329
 * @wiki
 * @server
 * @since 2025/5/21
 */
data class MessageBean(
    val id: Int,
    val avatar: String = "https://via.placeholder.com/50x50/2196F3/FFFFFF?text=Avatar",
    val title: String,
    val content: String,
    val time: String,
    val showDialog: Boolean = false
)
