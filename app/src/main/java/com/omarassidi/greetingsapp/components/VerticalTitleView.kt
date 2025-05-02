package com.omarassidi.greetingsapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omarassidi.greetingsapp.R
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme

@Composable
fun VerticalTitleView(onRotate: () -> Unit) {
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
    Column(
        modifier = Modifier.wrapContentSize().padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        GreetingsTextView(subTitle = subTitle) {
            subTitle = subTitles.random()
        }
        RingView(onRotate = onRotate)
    }
}

@Preview
@Composable
fun VerticalTitlePreview() {
    GreetingsAppTheme {
        VerticalTitleView{}
    }
}