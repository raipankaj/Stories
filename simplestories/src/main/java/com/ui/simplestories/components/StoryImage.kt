package com.ui.simplestories.components

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StoryImage(pagerState: PagerState, content: @Composable (Int) -> Unit) {
    HorizontalPager(state = pagerState, dragEnabled = false) {
        content(it)
    }
}
