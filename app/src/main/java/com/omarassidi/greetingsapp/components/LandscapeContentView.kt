package com.omarassidi.greetingsapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme

@Composable
fun LandscapeContentView() {
        Row {
            VerticalTitleView()
            Spacer(modifier = Modifier.width(130.dp))
            MessagesView()
        }
}

@Preview(heightDp = 360, widthDp = 800)
@Composable
fun LandscapeContentViewPreview() {
    GreetingsAppTheme {
        LandscapeContentView()
    }
}