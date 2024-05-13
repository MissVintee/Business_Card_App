package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    `Card-infoText`(backgroundColor = Color(0xCE8CE9BE))
                }
            }
        }
    }
}


@Composable
fun `Card-infoText`(
    backgroundColor: Color,
    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            FullNameStyle(
                fullName = "Vintee Chauhan",
                title = "Beginner Android Developer",
                backgroundColor = Color(0xFF033041)
            )
        }
        Row {
            Spacer(Modifier.size(100.dp))
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Column {
                MyAppIcon(icons = R.drawable.phone)
                MyAppIcon(icons = R.drawable.share)
                MyAppIcon(icons = R.drawable.email)
            }
            Column {
                InfoText(info = "+91 90378-XXXXX")
                InfoText(info = "@SocialMediaHandle")
                InfoText(info = "some@email.com")
            }
        }
    }
}


@Composable
private fun FullNameStyle(
    fullName: String,
    title: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .background(backgroundColor)
                .padding(10.dp)
                .size(100.dp)
        )
        Text(
            text = fullName,
            fontFamily = FontFamily.Serif,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(2.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(2.dp)
        )
    }
}


@Composable
private fun MyAppIcon(icons: Int) {
    val image = painterResource(id = icons)
    Image(
        painter = image ,
        contentDescription = null,
        modifier = Modifier.padding(4.dp)
    )
}


@Composable
private fun InfoText(info: String) {
    Text(
        text = info,
        modifier = Modifier.padding(5.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BusinessCardAppTheme {
        `Card-infoText`(backgroundColor = Color(0xAD8CE9BE))
    }
}