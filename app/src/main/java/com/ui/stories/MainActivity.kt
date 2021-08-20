package com.ui.stories

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.ui.simplestories.Stories
import com.ui.stories.ui.theme.StoriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val listOfImages = listOf(R.drawable.zoo_one, R.drawable.zoo_two, R.drawable.zoo_three)

    Stories(numberOfPages = listOfImages.size,
        onEveryStoryChange = { position ->
            Log.i("DATA", "Story Change $position")
        },
        onComplete = {
        Log.i("Action", "Completed")
    }) { index ->
        Image(painter = painterResource(id = listOfImages[index]), contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
    }
}
