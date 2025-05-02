package com.omarassidi.greetingsapp.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun RingView(onRotate: () -> Unit) {
    val pink = Color(0xFFFFC0CB)
    val purple = Color(0xFF800080)
    val orange = Color(0xFFFFA500)
    var isRotated by rememberSaveable {
        mutableStateOf(false)
    }
    val angle: Float = if (isRotated) 0.0f else 360.0f
    val angleState by animateFloatAsState(targetValue = angle, label = "")
    Canvas(modifier = Modifier
        .size(60.dp)
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            isRotated = !isRotated
            onRotate()
        }) {
        rotate(degrees = angleState) {
            drawCircle(
                radius = 30.dp.toPx(), brush = Brush.sweepGradient(
                    colors = listOf(pink, purple, Color.Blue, orange, Color.Yellow)
                ),
                style = Stroke(width = 15.dp.toPx())
            )
        }
    }
}