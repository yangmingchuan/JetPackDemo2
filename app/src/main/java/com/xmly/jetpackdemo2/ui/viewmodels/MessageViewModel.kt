package com.xmly.jetpackdemo2.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.xmly.jetpackdemo2.MessageBean
import com.xmly.jetpackdemo2.data.MessageRepository

class MessageViewModel : ViewModel() {
    
    private val repository = MessageRepository()
    
    private val _messages = mutableStateListOf<MessageBean>()
    
    init {
        _messages.addAll(repository.getMessages())
    }
    
    val messages: SnapshotStateList<MessageBean> = _messages
    
    fun addRandomMessage() {
        repository.addRandomMessage()
        val newMessages = repository.getMessages()
        _messages.clear()
        _messages.addAll(newMessages)
    }
    
    fun getMessageById(id: Int): MessageBean? {
        return messages.find { it.id == id }
    }
    
    fun getMessagesByTitle(title: String): List<MessageBean> {
        return messages.filter { it.title.contains(title, ignoreCase = true) }
    }
}
