package com.ui.simplestories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.ui.simplestories.components.LinearIndicator
import com.ui.simplestories.components.StoryImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class,ExperimentalComposeUiApi::class)
@Composable
fun Stories(
    listOfPages: Int,
    indicatorModifier: Modifier = Modifier
        .padding(top = 12.dp, bottom = 12.dp)
        .clip(RoundedCornerShape(12.dp)),
    spaceBetweenIndicator: Dp = 4.dp,
    indicatorBackgroundColor: Color = Color.LightGray,
    indicatorProgressColor: Color = Color.White,
    indicatorBackgroundGradientColors: List<Color> = emptyList(),
    slideDurationInSeconds: Long = 5,
    touchToPause: Boolean = true,
    content: @Composable (Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = listOfPages)
    val coroutineScope = rememberCoroutineScope()

    var currentPage by remember {
        mutableStateOf(0)
    }
    var pauseTimer by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        //Full screen content behind the indicator
        StoryImage(pagerState = pagerState, onTap = {
            if (touchToPause)
                pauseTimer = it
        }, content)

        //Indicator based on the number of items
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        if (indicatorBackgroundGradientColors.isEmpty()) listOf(
                            Color.Black,
                            Color.Transparent
                        ) else indicatorBackgroundGradientColors
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.padding(spaceBetweenIndicator))

            for (index in 0 until listOfPages) {
                LinearIndicator(
                    modifier = indicatorModifier.weight(1f),
                    index == currentPage,
                    indicatorBackgroundColor,
                    indicatorProgressColor,
                    slideDurationInSeconds,
                    pauseTimer,
                ) {
                    coroutineScope.launch {
                        if (currentPage < listOfPages - 1) {
                            currentPage++
                        }

                        pagerState.animateScrollToPage(currentPage)
                    }
                }

                Spacer(modifier = Modifier.padding(spaceBetweenIndicator))
            }
        }
    }
}