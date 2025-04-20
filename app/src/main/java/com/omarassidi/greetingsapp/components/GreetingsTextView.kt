package com.omarassidi.greetingsapp.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.omarassidi.greetingsapp.R

@Composable
fun GreetingsTextView(modifier: Modifier = Modifier, @StringRes subTitle: Int, onClick: () -> Unit) {
    Column(modifier = modifier
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            onClick()
        }
    ) {
        Text(
            text = stringResource(id = R.string.greetings),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = stringResource(id = subTitle),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Light
        )
    }
}