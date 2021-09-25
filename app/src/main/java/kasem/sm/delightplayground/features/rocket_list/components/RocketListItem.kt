package kasem.sm.delightplayground.features.rocket_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import kasem.sm.delightplayground.R
import kasem.sm.delightplayground.core.components.Image
import kasem.sm.delightplayground.datasource.Rocket
import kasem.sm.delightplayground.ui.theme.delightBackground

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RocketItem(
    rocket: Rocket,
    imageLoader: ImageLoader,
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(12.dp)
            .clip(
                CutCornerShape(
                    topEnd = 6.dp, bottomStart = 18.dp,
                    topStart = 6.dp, bottomEnd = 6.dp
                ),
            )
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(bounded = true),
                onClick = {
                    onItemClicked(rocket.id.toInt())
                }
            ),
        border = BorderStroke(
            width = 1.dp,
            brush = Brush.verticalGradient(
                colors = if (isSystemInDarkTheme()) {
                    listOf(Color.Transparent, Color.Red.copy(alpha = 0.2f))
                } else {
                    listOf(Color.Transparent, Color.Black.copy(alpha = 0.2f))
                }
            )
        ),
        shape = CutCornerShape(
            topEnd = 6.dp, bottomStart = 18.dp,
            topStart = 6.dp, bottomEnd = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .background(delightBackground())
        ) {

            /**
             * Get the first url from list
             * */

            val imageUrl = rocket.image[1]

            imageLoader.Image(
                modifier = Modifier
                    .height(200.dp),
                data = imageUrl
            )
            RocketListItemDescription(
                text = rocket.rocketTitle,
                icon = R.drawable.ic_rocket,
                isActive = rocket.active.toInt() == 1
            )
            RocketListItemDescription(
                text = rocket.country,
                icon = R.drawable.ic_pin
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
