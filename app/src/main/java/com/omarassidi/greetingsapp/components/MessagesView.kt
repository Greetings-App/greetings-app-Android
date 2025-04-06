package com.omarassidi.greetingsapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme


data class Message(val text: String, val color: Color)

@Composable
fun MessagesView() {
    val messages = listOf(
        Message(
            text = "Welcome to Jetpack Compose Programming", color = Color.Gray
        ),
        Message(text = "Hello there", color = Color.Green),
        Message(text = "Yes I am", color = Color.Yellow),
        Message(text = "Boom.", color = Color.Red),
    )
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        for (message in messages) {
            TextPill(text = message.text, color = message.color)
        }
    }
}

@Preview
@Composable
fun MessagesViewPreview() {
    GreetingsAppTheme {
        MessagesView()
    }
}