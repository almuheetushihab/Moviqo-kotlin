package com.shihab.moviqo
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.shihab.moviqo.ui.theme.Black
import com.shihab.moviqo.ui.theme.DarkGray
import com.shihab.moviqo.ui.theme.LightGray
import com.shihab.moviqo.ui.theme.NetflixRed
import com.shihab.moviqo.ui.theme.Pink40
import com.shihab.moviqo.ui.theme.PurpleGrey40
import com.shihab.moviqo.ui.theme.White

// ডার্ক মোড কালার স্কিম (Netflix Style)
private val DarkColorScheme = darkColorScheme(
    primary = NetflixRed,
    secondary = DarkGray,
    tertiary = LightGray,
    background = Black,
    surface = DarkGray,
    onPrimary = White,
    onBackground = White,
    onSurface = White
)

// লাইট মোড কালার স্কিম (Fallback)
private val LightColorScheme = lightColorScheme(
    primary = NetflixRed,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = White,
    surface = Color(0xFFF5F5F5),
    onPrimary = White,
    onBackground = Black,
    onSurface = Black
)

//@Composable
//fun MoviqoTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = false, // আমরা false রাখছি যাতে আমাদের কাস্টম কালার দেখায়
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme // ডিফল্ট হিসেবে লাইট মোডও রাখতে পারেন, তবে মুভি অ্যাপে ডার্ক ভালো লাগে
//    }
//
//    // স্ট্যাটাস বারের কালার ঠিক করার জন্য
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.background.toArgb() // স্ট্যাটাস বার ব্যাকগ্রাউন্ড কালার হবে
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
//        }
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
//}