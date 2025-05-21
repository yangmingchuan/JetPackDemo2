package com.xmly.jetpackdemo2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xmly.jetpackdemo2.ui.theme.JetpackDemo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SimpleWidgetColumn()
                }
            }
        }
    }
}

@Composable
fun SimpleWidgetColumn() {
    val context = LocalContext.current
    Surface(
        shape = MaterialTheme.shapes.medium, // 使用 MaterialTheme 自带的形状
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Column {
            Row (modifier = Modifier.padding(all = 8.dp)){

                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "profile picture", //这个描述用于无障碍
                    modifier = Modifier
                        .size(50.dp) // 改变 Image 元素的大小
                        .clip(CircleShape) // 将图片裁剪成圆形
                        .border(border = BorderStroke(1.dp, color = Color.Blue), shape = CircleShape) // 添加边框
                )
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Text(
                    text = "This is Text",
                    color = MaterialTheme.colorScheme.error, // 添加颜色
                    fontSize = 24.sp
                )
            }

            Button(onClick = {
                Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
            }) {
                Text(
                    text = "This is Button",
                    color = Color.White,
                    fontSize = 26.sp
                )
            }
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Type something here")
                }
            )
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SimpleWidgetColumn()
        }
    }
}