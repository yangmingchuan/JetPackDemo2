package com.xmly.jetpackdemo2.data

import com.xmly.jetpackdemo2.MessageBean
import kotlin.random.Random

class MessageRepository {
    
    private val _messages = mutableListOf(
        MessageBean(
            id = 1,
            avatar = "https://via.placeholder.com/50x50/2196F3/FFFFFF?text=Android",
            title = "Android开发",
            content = "Jetpack Compose是Android推荐的现代UI工具包",
            time = "10:30 AM"
        ),
        MessageBean(
            id = 2,
            avatar = "https://via.placeholder.com/50x50/4CAF50/FFFFFF?text=Kotlin",
            title = "Kotlin学习",
            content = "Kotlin是一种跨平台、静态类型、开源的编程语言",
            time = "11:45 AM"
        ),
        MessageBean(
            id = 3,
            avatar = "https://via.placeholder.com/50x50/FF9800/FFFFFF?text=喜马拉雅",
            title = "喜马拉雅",
            content = "发现更多有声内容和播客",
            time = "12:15 PM",
            showDialog = true
        ),
        MessageBean(
            id = 4,
            avatar = "https://via.placeholder.com/50x50/9C27B0/FFFFFF?text=Material",
            title = "Material Design",
            content = "Material Design是Google推出的设计语言",
            time = "1:30 PM"
        ),
        MessageBean(
            id = 5,
            avatar = "https://via.placeholder.com/50x50/F44336/FFFFFF?text=性能",
            title = "Android性能优化",
            content = "学习如何优化应用性能和用户体验",
            time = "3:45 PM"
        ),
        MessageBean(
            id = 6,
            avatar = "https://via.placeholder.com/50x50/607D8B/FFFFFF?text=功耗",
            title = "Android功耗优化",
            content = "学习如何优化应用功耗性能和用户体验",
            time = "3:46 PM"
        )
    )
    
    fun getMessages(): List<MessageBean> = _messages.toList()
    
    fun addRandomMessage() {
        val randomId = Random.nextInt(1000, 9999)
        val randomTitle = getRandomTitle()
        val randomContent = getRandomContent()
        val randomTime = getRandomTime()
        val randomShowDialog = Random.nextBoolean()
        val randomAvatar = getRandomAvatar()
        
        val newMessage = MessageBean(
            id = randomId,
            avatar = randomAvatar,
            title = randomTitle,
            content = randomContent,
            time = randomTime,
            showDialog = randomShowDialog
        )
        
        _messages.add(newMessage)
    }
    
    private fun getRandomTitle(): String {
        val titles = listOf(
            "随机消息${Random.nextInt(1, 100)}",
            "新功能${Random.nextInt(1, 50)}",
            "更新通知${Random.nextInt(1, 30)}",
            "系统消息${Random.nextInt(1, 20)}",
            "用户反馈${Random.nextInt(1, 15)}"
        )
        return titles.random()
    }
    
    private fun getRandomContent(): String {
        val contents = listOf(
            "这是一个随机生成的消息内容，ID为${Random.nextInt(1000, 9999)}",
            "Jetpack Compose 随机消息：${Random.nextInt(1, 100)}",
            "Android开发随机提示：${Random.nextInt(1, 50)}",
            "随机通知内容：${Random.nextInt(1, 30)}",
            "系统随机消息：${Random.nextInt(1, 20)}"
        )
        return contents.random()
    }
    
    private fun getRandomTime(): String {
        val hours = Random.nextInt(0, 24)
        val minutes = Random.nextInt(0, 60)
        val ampm = if (hours < 12) "AM" else "PM"
        val displayHours = if (hours == 0) 12 else if (hours > 12) hours - 12 else hours
        return String.format("%d:%02d %s", displayHours, minutes, ampm)
    }

    private fun getRandomAvatar(): String {
        val colors = listOf("2196F3", "4CAF50", "FF9800", "9C27B0", "F44336", "607D8B", "795548", "E91E63")
        val color = colors.random()
        return "https://via.placeholder.com/50x50/$color/FFFFFF?text=Random"
    }
}
