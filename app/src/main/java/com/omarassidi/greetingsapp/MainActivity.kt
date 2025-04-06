package com.omarassidi.greetingsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omarassidi.greetingsapp.components.MessagesView
import com.omarassidi.greetingsapp.components.TitleView
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb()
            ),
            statusBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb()
            )
        )
        setContent {
            GreetingsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentView()
                }
            }
        }
    }
}

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .drawWithCache {
                val gradient = Brush.linearGradient(
                    start = Offset.Zero, // topLeading
                    end = Offset(size.width, size.height), // bottomTrailing
                    colors = listOf(
                        Color.Blue.copy(alpha = 0.3f),
                        Color(139 / 255, 80 / 255, 240 / 255).copy(alpha = 0.3f)
                    )
                )
                onDrawBehind {
                    drawRect(brush = gradient)
                }
            }
            .safeContentPadding()
    )
    {
        Column {
            TitleView()
            Spacer(modifier = Modifier.height(130.dp))
            MessagesView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingsAppTheme {
        ContentView()
    }
}