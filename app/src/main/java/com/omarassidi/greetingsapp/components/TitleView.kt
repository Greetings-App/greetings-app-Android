package com.omarassidi.greetingsapp.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme

@Composable
fun TitleView() {
    Column {
        Text(
            text = "Greetings",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Explore Jetpack Compose Development",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Light
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitleViewPreview() {
    GreetingsAppTheme {
        TitleView()
    }
}