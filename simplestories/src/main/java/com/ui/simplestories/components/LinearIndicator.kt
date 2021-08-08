package com.ui.simplestories.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LinearIndicator(modifier: Modifier,
                    startProgress: Boolean = false,
                    indicatorBackgroundColor: Color,
                    indicatorProgressColor: Color,
                    slideDurationInSeconds: Long,
                    onAnimationEnd: () -> Unit) {

    val delayInMillis = rememberSaveable {
        (slideDurationInSeconds * 1000) / 100
    }

    var progress by remember {
        mutableStateOf(0.00f)
    }

    val animatedProgress by animateFloatAsState(targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec)

    if (startProgress) {
        LaunchedEffect(key1 = Unit) {
            while (progress < 1f) {
                progress += 0.01f
                delay(delayInMillis)
            }

            onAnimationEnd()
        }
    }

    LinearProgressIndicator(
        backgroundColor = indicatorBackgroundColor,
        color = indicatorProgressColor,
        modifier = modifier
            .padding(top = 12.dp, bottom = 12.dp)
            .clip(RoundedCornerShape(12.dp)),
        progress = animatedProgress
    )
}