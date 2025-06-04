package com.xmly.jetpackdemo2

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    
    // 创建模拟数据
    private val messageList = listOf(
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
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageList(messages = messageList)
                }
            }
        }
    }
}

@Composable
fun MessageList(messages: List<MessageBean>) {
    LazyColumn {
        items(messages) { message ->
            MessageItem(message = message)
        }
    }
}

@Composable
fun MessageItem(message: MessageBean) {
    val context = LocalContext.current
    var isExpanded = remember { mutableStateOf(false) } // 创建一个能够检测卡片是否被展开的变量
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { // 添加一个新的 Modifier 扩展方法，可以让元素具有点击的效果
                isExpanded.value = !isExpanded.value // 使用.value来访问和修改状态
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
                Image(
                    painterResource(id = message.avatar),
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
                    Toast.makeText(context, "消息ID: ${message.id}", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "查看")
                }
            }
            
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            
            // 根据折叠状态显示不同内容
            if (isExpanded.value) {
                // 展开时显示完整内容
                Text(
                    text = message.content,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
                
                // 添加额外的详细信息
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = "详细信息: ID ${message.id} 的消息",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 4.dp)
                )
                
                // 添加一个指示折叠的文本
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
                    maxLines = 1, // 限制最大行数
                    modifier = Modifier.padding(start = 4.dp)
                )
                
                // 添加一个指示展开的文本
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

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun MessageListPreview() {
    val previewMessages = listOf(
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
        )
    )
    
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MessageList(messages = previewMessages)
        }
    }
}