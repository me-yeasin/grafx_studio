package com.grafxstudio.grafx_studio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.grafxstudio.grafx_studio.config.root_navigation.navigation.RootNavigation
import com.grafxstudio.grafx_studio.ui.theme.Grafx_StudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            GrafxStudio()
        }
    }
}


@Composable
fun GrafxStudio() {
    Grafx_StudioTheme(darkTheme = false) {
        RootNavigation()
    }
}

