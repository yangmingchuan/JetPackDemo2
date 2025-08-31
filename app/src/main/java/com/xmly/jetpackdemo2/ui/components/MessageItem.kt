package com.xmly.jetpackdemo2.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.xmly.jetpackdemo2.MessageBean

@Composable
fun MessageItem(message: MessageBean) {
    val context = LocalContext.current
    var isExpanded = remember { mutableStateOf(false) }
    var showDialog = remember { mutableStateOf(false) }
    
    // 弹窗逻辑
    if (showDialog.value && message.showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = {
                Text(
                    text = "喜马拉雅消息",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall
                )
            },
            text = {
                Text(
                    text = "这是一条来自喜马拉雅的重要消息：${message.content}",
                    fontSize = 16.sp
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text(
                        "确认",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text(
                        "取消",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable {
                isExpanded.value = !isExpanded.value
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = message.avatar,
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(
                            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
                            shape = CircleShape
                        )
                )
                
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                
                Column {
                    Text(
                        text = message.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    
                    Text(
                        text = message.time,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                Button(onClick = {
                    if (message.showDialog) {
                        showDialog.value = true
                    } else {
                        Toast.makeText(context, "消息ID: ${message.id}", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text(text = "查看")
                }
            }
            
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            
            if (isExpanded.value) {
                // 展开时显示完整内容
                Text(
                    text = message.content,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
                
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = "详细信息: ID ${message.id} 的消息",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 4.dp)
                )
                
                Text(
                    text = "点击收起",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 8.dp, start = 4.dp)
                )
            } else {
                // 折叠时只显示简短内容
                Text(
                    text = message.content,
                    fontSize = 16.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 4.dp)
                )
                
                Text(
                    text = "点击展开更多...",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 4.dp, start = 4.dp)
                )
            }
        }
    }
}
