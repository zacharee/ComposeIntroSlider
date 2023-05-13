package dev.zwander.composeintroslidersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            var allowed by remember {
                mutableStateOf(false)
            }

            ComposeIntroSliderTheme {
                IntroSlider(
                    pages = remember {
                        listOf(
                            SimpleIntroPage(
                                title = { "Hue" },
                                slideColor = { Color.Red },
                                contentColor = { Color.White },
                                extraContent = {
                                    OutlinedButton(onClick = {}) {
                                        Text(text = "Test")
                                    }
                                },
                            ),
                            SimpleIntroPage(
                                title = { "Two" },
                                slideColor = { Color.Green },
                                contentColor = { Color.Black },
                                extraContent = {
                                    OutlinedButton(onClick = {}) {
                                        Text(text = "Test")
                                    }
                                }
                            ),
                            SimpleIntroPage(
                                title = { "Blocked" },
                                slideColor = { Color.Cyan },
                                contentColor = { Color.Black },
                                extraContent = {
                                    Switch(
                                        checked = allowed,
                                        onCheckedChange = { allowed = it }
                                    )
                                },
                                canMoveForward = { allowed }
                            ),
                            SimpleIntroPage(
                                title = { "Three" },
                                slideColor = { Color.Black },
                                contentColor = { Color.White },
                                extraContent = {
                                    OutlinedButton(onClick = {}) {
                                        Text(text = "Test")
                                    }
                                }
                            )
                        )
                    },
                    onExit = { /*TODO*/ },
                    onDone = { /*TODO*/ },
                    backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
                    normalizeElements = true
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