package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NameCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
//3b724a 글자 초록
//1a343f 이미지 배경 군청
//b6c8b9 전체 배경 연두
@Composable
fun NameCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color(0xFFb6c8b9))
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
        ) {
            PutImage()
            PutMainInfo()
        }
        Column {
            PutSubInfo()
        }
    }
}

@Composable
fun PutImage(modifier: Modifier = Modifier) {
    val androidLogo = painterResource(R.drawable.android_logo)
    Image(
        painter = androidLogo,
        contentDescription = null,
        modifier = Modifier
            .background(Color(0xFF1a343f))
            .width(120.dp)
            .height(120.dp)
    )
}

@Composable
fun PutMainInfo(modifier: Modifier = Modifier) {

}

@Composable
fun PutSubInfo(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        NameCard()
    }
}