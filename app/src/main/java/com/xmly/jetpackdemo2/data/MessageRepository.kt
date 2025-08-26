package com.xmly.jetpackdemo2.data

import com.xmly.jetpackdemo2.MessageBean

class MessageRepository {
    
    fun getMessages(): List<MessageBean> {
        return listOf(
            MessageBean(
                id = 1,
                title = "Android开发",
                content = "Jetpack Compose是Android推荐的现代UI工具包",
                time = "10:30 AM"
            ),
            MessageBean(
                id = 2,
                title = "Kotlin学习",
                content = "Kotlin是一种跨平台、静态类型、开源的编程语言",
                time = "11:45 AM"
            ),
            MessageBean(
                id = 3,
                title = "喜马拉雅",
                content = "发现更多有声内容和播客",
                time = "12:15 PM"
            ),
            MessageBean(
                id = 4,
                title = "Material Design",
                content = "Material Design是Google推出的设计语言",
                time = "1:30 PM"
            ),
            MessageBean(
                id = 5,
                title = "Android性能优化",
                content = "学习如何优化应用性能和用户体验",
                time = "3:45 PM"
            ),
            MessageBean(
                id = 6,
                title = "Android功耗优化",
                content = "学习如何优化应用功耗性能和用户体验",
                time = "3:46 PM"
            )
        )
    }
}
