package com.grafxstudio.grafx_studio.features.home.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.grafxstudio.grafx_studio.R
import com.grafxstudio.grafx_studio.config.font.logoTextStyle
import com.grafxstudio.grafx_studio.features.home.pages.HomePage
import com.grafxstudio.grafx_studio.features.home.pages.PortfolioPage
import com.grafxstudio.grafx_studio.features.home.pages.ServicePage
import com.grafxstudio.grafx_studio.features.home.pages.SubscriptionAndPricingPage
import com.grafxstudio.grafx_studio.features.home.pages.SupportPage
import com.grafxstudio.grafx_studio.features.home.pages.TestimonialAndReviewPage
import com.grafxstudio.grafx_studio.features.home.widgets.DrawerContent
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val pageNavController = rememberNavController()
    val scope = rememberCoroutineScope()
    val navBackStackEntry = pageNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination
    val foundHomeDestination = currentDestination?.hierarchy?.any {
        it.route == Pages.HomePage.name
    } == true
    val homePageScrollState: ScrollState = rememberScrollState()


    fun onDrawerButtonClick() {
        scope.launch {
            drawerState.apply {
                if (isClosed) open() else close()
            }
        }
    }

    fun onChangeTab(route: String) {
        pageNavController.navigate(route) {
            popUpTo(pageNavController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
        onDrawerButtonClick()
    }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent(currentDestination) { route -> onChangeTab(route) } }) {
        Scaffold(
            topBar = {
                AnimatedVisibility(visible = (!foundHomeDestination || homePageScrollState.value > 100)) {
                    TopAppBar(
                        title = {
                            if (foundHomeDestination) Text(
                                text = "Grafx Studio",
                                style = logoTextStyle
                            )
                        },
                        navigationIcon = {
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
                        })
                }
            },


            contentWindowInsets = WindowInsets.navigationBars
        ) { innerPadding ->
            NavHost(
                navController = pageNavController,
                startDestination = Pages.HomePage.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Pages.HomePage.name) { HomePage(homePageScrollState) { onDrawerButtonClick() } }
                composable(Pages.ServicePage.name) { ServicePage() }
                composable(Pages.PortfolioPage.name) { PortfolioPage() }
                composable(Pages.TestimonialAndReviewPage.name) { TestimonialAndReviewPage() }
                composable(Pages.SubscriptionAndPricingPage.name) { SubscriptionAndPricingPage() }
                composable(Pages.SupportPage.name) { SupportPage() }
            }
        }
    }
}

enum class Pages {
    HomePage,
    ServicePage,
    PortfolioPage,
    TestimonialAndReviewPage,
    SubscriptionAndPricingPage,
    SupportPage;
}
