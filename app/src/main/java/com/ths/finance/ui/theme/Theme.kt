package com.ths.finance.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val CharcoalSlate = Color(0xFF263238)
val ElectricIndigo = Color(0xFF536DFE)
val LightSlate = Color(0xFFECEFF1)
val MintGreen = Color(0xFF00C853)

private val DarkColorScheme = darkColorScheme(
    primary = ElectricIndigo,
    secondary = MintGreen,
    tertiary = CharcoalSlate,
    background = CharcoalSlate,
    surface = CharcoalSlate,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = ElectricIndigo,
    secondary = MintGreen,
    tertiary = CharcoalSlate,
    background = LightSlate,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = CharcoalSlate,
    onSurface = CharcoalSlate,
)

@Composable
fun THSFinanceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
