package com.grafxstudio.grafx_studio.features.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.grafxstudio.grafx_studio.R
import com.grafxstudio.grafx_studio.config.font.montFamily
import com.grafxstudio.grafx_studio.features.home.screen.Pages

@Composable
fun DrawerContent(currentDestination: NavDestination?, onChangeTab: (route: String) -> Unit) {
    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxWidth(0.8f),
        windowInsets = WindowInsets.statusBars
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.grafx_logo_without_text),
                    contentDescription = "Company Logo",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(10.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .graphicsLayer {
                        this.translationY = 10f
                    }
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "Grafx Studio", style = TextStyle(
                        fontFamily = montFamily,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 22.sp
                    )
                )
                Text(text = "Design Your Brand Today")
            }
        }
        Spacer(modifier = Modifier.height(60.dp))
        DrawerNavigationItem(
            iconResourceId = R.drawable.home_icon,
            iconAlt = "Home Icon",
            name = "Home",
            isActive = currentDestination?.hierarchy?.any { it.route == Pages.HomePage.name } == true
        ) { onChangeTab(Pages.HomePage.name) }
        DrawerNavigationItem(
            iconResourceId = R.drawable.service_icon,
            iconAlt = "Service Icon",
            name = "Service",
            isActive = currentDestination?.hierarchy?.any { it.route == Pages.ServicePage.name } == true
        ) { onChangeTab(Pages.ServicePage.name) }
        DrawerNavigationItem(
            iconResourceId = R.drawable.portfolio_icon,
            iconAlt = "Portfolio Icon",
            name = "Portfolio",
            isActive = currentDestination?.hierarchy?.any { it.route == Pages.PortfolioPage.name } == true
        ) { onChangeTab(Pages.PortfolioPage.name) }
        DrawerNavigationItem(
            iconResourceId = R.drawable.subscription_and_pricing,
            iconAlt = "Subscription and Pricing Icon",
            name = "Subscription & Pricing",
            isActive = currentDestination?.hierarchy?.any { it.route == Pages.SubscriptionAndPricingPage.name } == true
        ) { onChangeTab(Pages.SubscriptionAndPricingPage.name) }
        DrawerNavigationItem(
            iconResourceId = R.drawable.testimonial_and_review_icon,
            iconAlt = "Testimonial And Review Icon",
            name = "Testimonial & Review",
            isActive = currentDestination?.hierarchy?.any { it.route == Pages.TestimonialAndReviewPage.name } == true
        ) { onChangeTab(Pages.TestimonialAndReviewPage.name) }
        DrawerNavigationItem(
            iconResourceId = R.drawable.support_icon,
            iconAlt = "Support Icon",
            name = "Support",
            isActive = currentDestination?.hierarchy?.any { it.route == Pages.SupportPage.name } == true
        ) { onChangeTab(Pages.SupportPage.name) }

    }
}