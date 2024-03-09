package com.grafxstudio.grafx_studio.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.grafxstudio.grafx_studio.config.font.titleTextStyle
import com.grafxstudio.grafx_studio.ui.theme.primary
import com.grafxstudio.grafx_studio.ui.theme.secondary

@Composable
fun ItemHorizontalListLayout(
    modifier: Modifier = Modifier,
    items: List<String>,
    title: String,
    cardHeight : Int = 160,
    cardWidth : Int = 150,
    sellAllBtnClick: () -> Unit,
    onCardClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 20.dp)
            ) {
                Text(text = title, style = titleTextStyle)
                TextButton(
                    onClick = { sellAllBtnClick() },
                    colors = ButtonDefaults.textButtonColors().copy(contentColor = secondary)
                ) {
                    Text(text = "See All", color = secondary)
                }
            }

            LazyRow(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                itemsIndexed(items) { _, _ ->
                    Card(
                        onClick = { onCardClick()},
                        modifier = Modifier
                            .height(cardHeight.dp)
                            .width(cardWidth.dp)
                            .padding(horizontal = 2.dp),
                        colors = CardDefaults.cardColors(containerColor = primary)
                    ) {

                    }
                }
            }
        }

    }
}