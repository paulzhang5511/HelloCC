package com.example.hellocc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellocc.ui.theme.HelloCCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloCCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    companion object {
        init {
            System.loadLibrary("rustlib")
            initLog()
        }
    }


}

//private external fun stringFromJNI(): String

private external fun hello(input: String): String

private external fun initLog()

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
//        Text(stringFromJNI())
        HorizontalDivider(modifier = Modifier.height(1.dp))
        Text(hello("hello"))
        HorizontalDivider(modifier = Modifier.height(1.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloCCTheme {
        Greeting("Android")
    }
}