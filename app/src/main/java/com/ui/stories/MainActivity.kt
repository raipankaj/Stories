package com.ui.stories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val listOfImages = listOf(R.drawable.zoo_one, R.drawable.zoo_two)

    Box(modifier = Modifier.height(350.dp).fillMaxWidth()) {
        Stories(listOfPages = listOfImages.size) {
            Image(painter = painterResource(id = listOfImages[it]), contentDescription = null,
                contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }
    }
}
