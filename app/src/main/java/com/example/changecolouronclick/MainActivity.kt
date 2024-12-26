package com.example.changecolouronclick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.changecolouronclick.ui.theme.ChangeColourOnClickTheme
import java.nio.file.WatchEvent
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChangeColourOnClickTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FinalBox()
                }
            }
        }
    }
}

@Composable
fun FinalBox() {
    Column(modifier = Modifier.fillMaxSize()) {

        var color = remember {
            mutableStateOf(Color.Yellow)
        }

        Box(
            modifier = Modifier
                .background(color.value)
                .weight(7f)
                .fillMaxSize()
        )

        ColorBox(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ){
            color.value = it
        }
    }
}

@Composable
fun ColorBox(
    modifier : Modifier = Modifier,
    updateColor: (Color) -> Unit
) {

    Box(modifier = modifier
        .background(Color.Black)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    alpha = 1f
                )
            )
        },
        contentAlignment = Alignment.Center

    ){
        Text(
            text = "Tap Here",
            modifier = Modifier.padding(horizontal = 100.dp, vertical = 30.dp),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

