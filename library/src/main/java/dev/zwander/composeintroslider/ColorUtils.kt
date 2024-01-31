package dev.zwander.composeintroslider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

@Composable
fun contentColorFor(color: Color): Color {
    return remember(color) {
        val luminance = color.luminance()

        if (luminance > 0.5) {
            Color.Black
        } else {
            Color.White
        }
    }
}
