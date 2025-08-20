package com.example.bmicalculater.Model

import android.view.SoundEffectConstants
import androidx.compose.runtime.Composable
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView

@Composable
fun rememberClickFeedback(): () -> Unit {
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current

    return {
        // 🔸 Vibrate
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)

        // 🔸 Play real system click sound
        view.playSoundEffect(SoundEffectConstants.CLICK)
    }
}
