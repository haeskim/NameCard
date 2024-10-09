package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NameCard(
                        name = stringResource(R.string.name),
                        title = stringResource(R.string.title),
                        phoneNumber = stringResource(R.string.phone_number),
                        sns = stringResource(R.string.sns),
                        eMail = stringResource(R.string.email),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//3b724a 글자 초록
//1a343f 이미지 배경 군청
//b6cbbf 전체 배경 연두
@Composable
fun NameCard(name: String, title: String, phoneNumber: String, sns: String, eMail: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color(0xFFb6cbbf))
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
                .weight(3f)
        ) {
            PutImage()
            PutMainInfo(
                name = name,
                title = title
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ){
            PutSubInfo(phoneNumber = phoneNumber, sns = sns, eMail = eMail)
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
fun PutMainInfo(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = name,
            fontSize = 36.sp,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = title,
            color = Color(0xFF3b724a),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun PutSubInfo(phoneNumber: String, sns: String, eMail: String, modifier: Modifier = Modifier) {
    Column {
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = null,
                tint = Color(0xFF3b724a)
            )
            Text(
                text = phoneNumber
            )
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = Icons.Rounded.Share,
                contentDescription = null,
                tint = Color(0xFF3b724a)
            )
            Text(
                text = sns
            )
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = Icons.Rounded.MailOutline,
                contentDescription = null,
                tint = Color(0xFF3b724a)
            )
            Text(
                text = eMail
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        NameCard(
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            phoneNumber = stringResource(R.string.phone_number),
            sns = stringResource(R.string.sns),
            eMail = stringResource(R.string.email)
        )
    }
}