package com.omarassidi.greetingsapp

import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omarassidi.greetingsapp.components.LandscapeContentView
import com.omarassidi.greetingsapp.components.MessagesView
import com.omarassidi.greetingsapp.components.TitleView
import com.omarassidi.greetingsapp.components.UserPreferences
import com.omarassidi.greetingsapp.components.isTablet
import com.omarassidi.greetingsapp.ui.theme.GreetingsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserPreferences(this).loadResources()
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb()
            ),
            statusBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb()
            )
        )
        setContent {
            GreetingsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@Composable
fun MainView() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    val gradient = Brush.linearGradient(
                        start = Offset.Zero, // topLeading
                        end = Offset(size.width, size.height), // bottomTrailing
                        colors = listOf(
                            Color.Blue.copy(alpha = 0.3f),
                            Color(139 / 255, 80 / 255, 240 / 255).copy(alpha = 0.3f)
                        )
                    )
                    onDrawBehind {
                        drawRect(brush = gradient)
                    }
                }
                .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Vertical))
                .padding(horizontal = 16.dp)

        ) {
            Column {
                LanguageOptionsView(modifier = Modifier.align(Alignment.End))
                if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT || isTablet()) {
                    ContentView()
                } else {
                    LandscapeContentView()
                }
            }
        }
}

@Composable
fun LanguageOptionsView(modifier: Modifier = Modifier) {
    val activity = LocalContext.current
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    Box(modifier = modifier) {
        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = "More options",
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                text = { Text(text = stringResource(id = R.string.english)) },
                onClick = {
                    UserPreferences(activity).setLocale("en")
                    expanded = false
                })
            DropdownMenuItem(
                text = { Text(text = stringResource(id = R.string.arabic)) },
                onClick = {
                    UserPreferences(activity).setLocale("ar")
                    expanded = false
                })
            DropdownMenuItem(
                text = { Text(text = stringResource(id = R.string.spanish)) },
                onClick = {
                    UserPreferences(activity).setLocale("es")
                    expanded = false
                })

        }
    }
}

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    Column {
        TitleView()
        Spacer(modifier = Modifier.height(130.dp))
        MessagesView()
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingsAppTheme {
        MainView()
    }
}