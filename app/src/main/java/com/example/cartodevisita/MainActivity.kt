package com.example.cartodevisita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartodevisita.ui.theme.CartãoDeVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartãoDeVisitaTheme {
                Surface (modifier = Modifier.fillMaxSize()
                ) {
                    FullName()
                    Dados()
                }
            }
        }
    }
}

@Composable
fun FullName(
    name: String = stringResource(R.string.full_Name),
    title: String = stringResource(R.string.title),
    imglogo: Painter = painterResource(R.drawable.pngwing)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF006437))
    ) {
        Image(
            painter = imglogo,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = title,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
        )
    }
}


@Composable
fun Dados(
    phone: String = "+55 11 98081-0888",
    email: String = "kleberdmx@gmail.com",
    socialMedia: String = "@slimsoni_"
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .offset(x = 90.dp)
    ) {
        InfoRow(
            icon = Icons.Filled.Call,
            text = phone
        )
        Spacer(modifier = Modifier.height(8.dp))
        InfoRow(
            icon = Icons.Filled.Email,
            text = email
        )
        Spacer(modifier = Modifier.height(8.dp))
        InfoRow(
            icon = Icons.Filled.FavoriteBorder,
            text = socialMedia
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Composable
fun InfoRow(                //template
    icon: ImageVector,
    text: String,
    iconTint: Color = Color(0xFF99cc00)
) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold)
    }

}


@Preview(showBackground = true)
@Composable
fun CartaoDeVisitaPreview() {
    CartãoDeVisitaTheme {
        FullName()
        Dados()
    }
}