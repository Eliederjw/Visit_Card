package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme

const val iconBackground = 0xFF073042
const val titleColor = 0xFF006A34
const val iconsColor = 0xFF006D3B
const val appBackgroundColor = 0xFFD2E8D4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitCardTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    AppVisitCard()
                }
            }
        }
    }
}

@Composable
fun AppVisitCard(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(appBackgroundColor)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(2f),
            contentAlignment = Alignment.Center

        ){
            NameProfile()
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.5f),
            contentAlignment = Alignment.TopCenter

        ){
            ContactData()
        }
    }
}

@Composable
fun NameProfile(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){

        AndroidLogo() // Logo

        Text( //Name
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(R.string.my_name),
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight(200),
            lineHeight = 40.sp
            )

        Text( // Title
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            text = stringResource(R.string.title),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 15.sp,
            color = Color(titleColor)
        )
    }
}

@Composable
fun ContactData(){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        IconAndData(Icons.Filled.Phone, stringResource(R.string.phone_number))
        IconAndData(Icons.Filled.Share, "@" + stringResource(R.string.social))
        IconAndData(Icons.Filled.Email, stringResource(R.string.email))
    }
}

@Composable
fun AndroidLogo(){
    Image(
        modifier = Modifier
            .background(Color(iconBackground))
            .size(120.dp),
        painter = painterResource(R.drawable.android_logo),
        contentDescription = null
    )
}

@Composable
fun IconAndData(icon: ImageVector, stringData: String = "Empty Text" ){
    Row (
        modifier = Modifier
            .padding(vertical = 8.dp),

        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            icon,
            contentDescription = null,
            tint = Color(iconsColor)
        )
        Text(
            modifier = Modifier
                .padding(start = 15.dp),
            text = stringData,
            fontSize = 15.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    VisitCardTheme {
        AppVisitCard()
    }
}