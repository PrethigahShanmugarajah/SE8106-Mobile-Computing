package com.example.activity02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.activity02.ui.theme.Activity02Theme
import androidx.compose.foundation.border
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Activity02Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
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
    Activity02Theme {
        Greeting("Android")
    }
}

@Composable
fun Hello() {
    Text(
        text = "Hello Students",
        fontSize = 32.sp,
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.Blue)
            .border(2.dp, androidx.compose.ui.graphics.Color.Magenta)
            .padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Hello()
}