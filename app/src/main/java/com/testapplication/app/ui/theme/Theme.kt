package com.testapplication.app.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush


private val PrimaryGradient = Brush.verticalGradient(
    colors = listOf(
        topColor,
        bottomColor
    )
)
private val colorScheme = darkColorScheme(
    primary = topColor,
    secondary = bottomColor,
    onPrimary = whiteColor,
    primaryContainer = transparentColor,
    surfaceContainerLow = grayColor,
)


@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.background(brush = PrimaryGradient).fillMaxSize()
    ) {
        content()
    }
}

@Composable
fun CustomTheme(content: @Composable () -> Unit) {
    TestApplicationTheme {
        GradientBackground {
            content()
        }
    }
}

@Composable
fun TestApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}