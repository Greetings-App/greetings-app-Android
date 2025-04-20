package com.omarassidi.greetingsapp.components

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.omarassidi.greetingsapp.R
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme


@Composable
fun isTablet(): Boolean {
    val configuration = LocalConfiguration.current
    return if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        configuration.screenWidthDp > 1000
    } else {
        configuration.screenWidthDp > 800
    }
}

@Composable
fun TextPill(@StringRes text: Int, color: Color, modifier: Modifier = Modifier) {
    var colorIndex by rememberSaveable {
        mutableIntStateOf(-1)
    }
    val textStyle =
        if (isTablet()) MaterialTheme.typography.displayLarge else MaterialTheme.typography.bodyLarge
    val colors = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color(0xFFFFA500), // Orange (Hex: #FFA500)
        Color.Yellow,
        Color(0xFF800080), // Purple (Hex: #800080)
        Color(red = 0.5f, green = 0f, blue = 0.5f),
        Color(red = 0f, green = 0.5f, blue = 0.5f),
        Color(red = 139f / 255f, green = 207f / 255f, blue = 240f / 255f),
        Color(red = 1f, green = 215f / 255f, blue = 0f)
    )
    val colorState by animateColorAsState(
        targetValue = colors.getOrNull(colorIndex) ?: color,
        label = ""
    )
    Text(
        text = stringResource(id = text),
        modifier = Modifier
            .zIndex(10f)
            .wrapContentSize()
            .shadow(
                elevation = 40.dp,
                spotColor = colorState,
                ambientColor = colorState,
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                color = colorState.copy(alpha = 0.4f),
                RoundedCornerShape(20.dp)
            )
            .padding(16.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                colorIndex = colors.indexOf(colors.random())
            },

        textAlign = TextAlign.Start,
        style = textStyle,
        fontWeight = FontWeight.SemiBold,
        color = Color.White,

        )
}

@Preview
@Composable
fun TextPillPreview() {
    GreetingsAppTheme {
        Column {
            TextPill(text = R.string.hello_there, color = Color.Yellow)
            TextPill(text = R.string.hello_there, color = Color.Blue)
            TextPill(text = R.string.hello_there, color = Color.Red)
        }
    }
}