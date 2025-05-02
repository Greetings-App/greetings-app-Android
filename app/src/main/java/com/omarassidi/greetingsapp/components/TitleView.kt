package com.omarassidi.greetingsapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.omarassidi.greetingsapp.R
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme

@Composable
fun TitleView(onRotate: () -> Unit) {
    val subTitles = listOf(
        R.string.explore_compose_development,
        R.string.views_are_old,
        R.string.compose_is_amazing,
        R.string.compose_is_awesome,
        R.string.compose_is_cool
    )
    var subTitle by rememberSaveable {
        mutableIntStateOf(subTitles.first())
    }
    Row(modifier = Modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically) {
        GreetingsTextView(modifier = Modifier.weight(1f), subTitle = subTitle) {
            subTitle = subTitles.random()
        }
        RingView(onRotate = onRotate)
    }
}

@Preview(showBackground = true)
@Composable
fun TitleViewPreview() {
    GreetingsAppTheme {
        TitleView {}
    }
}