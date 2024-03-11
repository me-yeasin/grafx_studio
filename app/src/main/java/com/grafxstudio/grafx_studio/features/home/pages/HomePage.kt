package com.grafxstudio.grafx_studio.features.home.pages

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.grafxstudio.grafx_studio.R
import com.grafxstudio.grafx_studio.config.font.logoTextStyle
import com.grafxstudio.grafx_studio.features.home.view_model.HomeViewModel
import com.grafxstudio.grafx_studio.features.home.widgets.AutoImageSlider
import com.grafxstudio.grafx_studio.widgets.ItemHorizontalListLayout

@Composable
fun HomePage(rootScrollState: ScrollState, onDrawerButtonClick: () -> Unit = {}) {
    val homeViewModel : HomeViewModel = hiltViewModel()
    // Dummy Images -> Replace with real image
    val images: List<String> = listOf(
        "https://images.unsplash.com/photo-1626251851903-1143b5c6f057?q=80&w=1892&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1522139137660-4248e04955b8?q=80&w=2076&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1620912189865-1e8a33da4c5e?q=80&w=2069&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    )

    Column(
        modifier = Modifier.verticalScroll(rootScrollState)
    ) {
        // Top Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp)

        ) {
            AutoImageSlider(images = images)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.graphicsLayer {
                    this.translationY = 60f
                    this.translationX = 20f
                }
            ) {
                Surface(
                    modifier = Modifier
                        .clickable {
                            onDrawerButtonClick()
                        },
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.background.copy(alpha = 0.7f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.drawer_icon),
                        contentDescription = "Navigation Drawer Icon",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(8.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                Text(
                    text = "Grafx Studio",
                    style = logoTextStyle,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

        }
        // End Top Header Section

        // Logo Section
        ItemHorizontalListLayout(
            title = "Logos",
            items = listOf("one", "two", "three"),
            sellAllBtnClick = {}) {}

        // T-Shirt Design
        ItemHorizontalListLayout(
            modifier = Modifier.padding(top = 20.dp),
            cardHeight = 250,
            cardWidth = 190,
            title = "T-Shirt Design",
            items = listOf("one", "two", "three"),
            sellAllBtnClick = {}) {}
    }
}