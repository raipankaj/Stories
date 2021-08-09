package com.ui.simplestories.components

import android.view.MotionEvent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalComposeUiApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun StoryImage(pagerState: PagerState, onTap: (Boolean) -> Unit, content: @Composable (Int) -> Unit) {
    HorizontalPager(state = pagerState, dragEnabled = false, modifier = Modifier.pointerInteropFilter {
        when(it.action) {
            MotionEvent.ACTION_DOWN -> {
                onTap(true)
            }

            MotionEvent.ACTION_UP -> {
                onTap(false)
            }
        }
        true
    }) {
        content(it)
    }
}
