package com.maurya91.composeway.core

import androidx.ui.graphics.Color
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette

val lightThemeColors = lightColorPalette(
    primary = Color(0xFFDD0D3C),
    primaryVariant = Color(0xFFC20029),
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFD00036),
    onError = Color.White
)

val darkThemeColors = darkColorPalette(
    primary = Color(0xFFEA6D7E),
    primaryVariant = Color(0xFFDD0D3E),
    onPrimary = Color.Black,
    secondary = Color(0xFF121212),
    onSecondary = Color.White,
    surface = Color(0xFF121212),
    background = Color(0xFF121212),
    onBackground = Color.White,
    onSurface = Color.White
)