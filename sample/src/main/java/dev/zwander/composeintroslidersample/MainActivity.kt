package dev.zwander.composeintroslidersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.zwander.composeintroslider.IntroSlider
import dev.zwander.composeintroslider.SimpleIntroPage
import dev.zwander.composeintroslidersample.ui.theme.ComposeIntroSliderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroSliderTheme {
                IntroSlider(
                    pages = remember {
                        listOf(
                            SimpleIntroPage(
                                title = { "Hue" },
                                slideColor = { Color.Red },
                                contentColor = { Color.White }
                            ),
                            SimpleIntroPage(
                                title = { "Two" },
                                slideColor = { Color.Green },
                                contentColor = { Color.Black }
                            ),
                            SimpleIntroPage(
                                title = { "Three" },
                                slideColor = { Color.Black },
                                contentColor = { Color.White }
                            )
                        )
                    },
                    onExit = { /*TODO*/ },
                    onDone = { /*TODO*/ },
                    backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroSliderTheme {
        Greeting("Android")
    }
}