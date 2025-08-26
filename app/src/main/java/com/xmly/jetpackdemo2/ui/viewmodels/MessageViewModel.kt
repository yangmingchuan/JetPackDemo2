package com.xmly.jetpackdemo2.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.xmly.jetpackdemo2.MessageBean
import com.xmly.jetpackdemo2.data.MessageRepository

class MessageViewModel : ViewModel() {
    
    private val repository = MessageRepository()
    
    val messages: List<MessageBean>
        get() = repository.getMessages()
    
    fun getMessageById(id: Int): MessageBean? {
        return messages.find { it.id == id }
    }
    
    fun getMessagesByTitle(title: String): List<MessageBean> {
        return messages.filter { it.title.contains(title, ignoreCase = true) }
    }
}
