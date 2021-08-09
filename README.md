# Stories
[![](https://jitpack.io/v/raipankaj/Stories.svg)](https://jitpack.io/#raipankaj/Stories)

Create stories with Jetpack Compose!

Adding stories are fun especially when your app deals with images.
Now with Jetpack Compose you can easily add stories to your existing app within 5 lines of code.

To get started with Stories just add the maven url and the Stories dependency

<b>build.gradle (Project level)</b>
```groovy
allprojects {
    repositories {
    ...
    //Add this url
    maven { url 'https://jitpack.io' }
    }
}
```
If you are using Android Studio Arctic Fox and do not have allProjects in build.gradle then add following maven url in <b>settings.gradle</b> like below
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //Add this url
        maven { url 'https://jitpack.io' }
        jcenter() // Warning: this repository is going to shut down soon
    }
}
```

Once you have added the maven url now add the Stories dependency in the <b>build.gradle (module level)</b>
```groovy
implementation 'com.github.raipankaj:Stories:1.0.0'
```

Congratulations, you have successfully added the dependency. 
Now to get started with Stories add the following code snippet
```kotlin
val listOfImages = listOf(R.drawable.mountains, R.drawable.forest)
Stories(listOfPages = listOfImages.size) {
    Image(painter = painterResource(id = listOfImages[it]), contentDescription = null,
    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
}
```
<br>
Stories composable provide an ability to change the color of progress indicator and also to add any composable as body instead of image composable.
Here are all the parameters accepted by Stories composable.

```kotlin
@Composable
fun Stories(
    listOfPages: Int,
    indicatorModifier: Modifier = Modifier.padding(top = 12.dp, bottom = 12.dp).clip(RoundedCornerShape(12.dp)),
    spaceBetweenIndicator: Dp = 4.dp,
    indicatorBackgroundColor: Color = Color.LightGray,
    indicatorProgressColor: Color = Color.White,
    indicatorBackgroundGradientColors: List<Color> = emptyList(),
    slideDurationInSeconds: Long = 5,
    touchToPause: Boolean = true,
    content: @Composable (Int) -> Unit
)
```
<br>
Based on your app theme and requirement it's extremely easy to modify the Stories composable with the set of parameters.

[![Demo](https://github.com/raipankaj/Stories/blob/main/stories.mp4)](https://github.com/raipankaj/Stories/blob/main/stories.mp4)


<br><br>
Note: If you like this library then please don't forget to hit the star button! :smiley:
