package com.xmly.jetpackdemo2.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.xmly.jetpackdemo2.ui.components.MessageItem
import com.xmly.jetpackdemo2.ui.viewmodels.MessageViewModel

@Composable
fun MessageListScreen(
    viewModel: MessageViewModel = MessageViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(viewModel.messages) { message ->
                MessageItem(message = message)
            }
        }
    }
}
