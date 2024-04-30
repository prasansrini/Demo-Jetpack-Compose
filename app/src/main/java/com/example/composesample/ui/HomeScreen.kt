package com.example.composesample.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composesample.BottomMenuContent
import com.example.composesample.Components.AquaBlue
import com.example.composesample.Components.Beige1
import com.example.composesample.Components.Beige2
import com.example.composesample.Components.Beige3
import com.example.composesample.Components.BlueViolet1
import com.example.composesample.Components.BlueViolet2
import com.example.composesample.Components.BlueViolet3
import com.example.composesample.Components.ButtonBlue
import com.example.composesample.Components.DarkerButtonBlue
import com.example.composesample.Components.DeepBlue
import com.example.composesample.Components.LightGreen1
import com.example.composesample.Components.LightGreen2
import com.example.composesample.Components.LightGreen3
import com.example.composesample.Components.LightRed
import com.example.composesample.Components.OrangeYellow1
import com.example.composesample.Components.OrangeYellow2
import com.example.composesample.Components.OrangeYellow3
import com.example.composesample.Components.TextWhite
import com.example.composesample.Feature
import com.example.composesample.R
import com.example.composesample.standardQuadFromTo

@Composable
fun HomeScreen() {
	Box(
		modifier = Modifier
			.background(DeepBlue)
			.fillMaxSize()
	) {
		Column {
			GreetingSection()
			ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
			CurrentMeditation()
			FeatureSection(
				featureList = listOf(
					Feature(
						title = "Sleep meditation",
						R.drawable.ic_headphone,
						BlueViolet1,
						BlueViolet2,
						BlueViolet3
					),
					Feature(
						title = "Tips for sleeping",
						R.drawable.ic_videocam,
						LightGreen1,
						LightGreen2,
						LightGreen3
					),
					Feature(
						title = "Night island",
						R.drawable.ic_headphone,
						OrangeYellow1,
						OrangeYellow2,
						OrangeYellow3
					),
					Feature(
						title = "Calming sounds",
						R.drawable.ic_headphone,
						Beige1,
						Beige2,
						Beige3
					)
				)
			)
		}

		BottomMenu(
			bottomMenuList = listOf(
				BottomMenuContent(
					"Home",
					R.drawable.ic_home
				),
				BottomMenuContent(
					"Meditate",
					R.drawable.ic_bubble
				),
				BottomMenuContent(
					"Sleep",
					R.drawable.ic_moon
				),
				BottomMenuContent(
					"Music",
					R.drawable.ic_music
				),
				BottomMenuContent(
					"Profile",
					R.drawable.ic_profile
				)
			),
			modifier = Modifier.align(Alignment.BottomCenter)
		)
	}
}

@Composable
fun BottomMenu(
	bottomMenuList: List<BottomMenuContent>,
	modifier: Modifier = Modifier,
	activeHightlightColor: Color = Color.Blue,
	activeTextColor: Color = Color.White,
	inactiveTextColor: Color = AquaBlue,
	initialSelectedIndex: Int = 0
) {
	var selectedItemIndex by remember {
		mutableStateOf(initialSelectedIndex)
	}

	Row(
		horizontalArrangement = Arrangement.SpaceAround,
		verticalAlignment = Alignment.CenterVertically,
		modifier = modifier
			.fillMaxWidth()
			.background(DeepBlue)
			.padding(15.dp)
	) {
		bottomMenuList.forEachIndexed { index, item ->
			BottomMenuItem(
				item = item,
				isSelected = index == selectedItemIndex,
				activeHightlightColor = activeHightlightColor,
				activeTextColor = activeTextColor,
				inactiveTextColor = inactiveTextColor
			) {
				selectedItemIndex = index
			}
		}
	}
}

@Composable
fun BottomMenuItem(
	item: BottomMenuContent,
	isSelected: Boolean = false,
	activeHightlightColor: Color = Color.Blue,
	activeTextColor: Color = Color.White,
	inactiveTextColor: Color = AquaBlue,
	onItemClicked: () -> Unit
) {
	Column(horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = Modifier.clickable {
			onItemClicked()
		}) {
		Box(
			contentAlignment = Alignment.Center,
			modifier = Modifier
				.clip(RoundedCornerShape(10.dp))
				.background(if (isSelected) activeHightlightColor else Color.Transparent)
				.padding(10.dp)
		) {
			Icon(
				painter = painterResource(id = item.iconId),
				contentDescription = item.title,
				tint = if (isSelected) activeTextColor else inactiveTextColor,
				modifier = Modifier.size(20.dp)
			)
		}
		Text(
			text = item.title,
			color = if (isSelected) activeTextColor else inactiveTextColor
		)
	}
}

@Composable
fun GreetingSection(
	name: String = "Prasanna"
) {
	Row(
		horizontalArrangement = Arrangement.Absolute.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {
		Column(
			verticalArrangement = Arrangement.Center
		) {
			Text(
				text = "Good morning, $name!",
				color = TextWhite,
				style = MaterialTheme.typography.titleSmall,
				fontWeight = FontWeight.Bold
			)
			Text(
				text = "We wish you have a good day!",
				color = TextWhite,
				style = MaterialTheme.typography.bodySmall
			)
		}
		Icon(
			painter = painterResource(id = R.drawable.ic_search),
			tint = Color.White,
			contentDescription = "Search",
			modifier = Modifier.size(24.dp)
		)
	}
}

@Composable
fun ChipSection(
	chips: List<String>
) {
	var selectedChipIndex by remember {
		mutableIntStateOf(0)
	}

	LazyRow {
		items(chips.size) {
			Box(modifier = Modifier
				.padding(
					start = 15.dp,
					top = 15.dp,
					bottom = 15.dp
				)
				.clickable {
					selectedChipIndex = it
				}
				.clip(RoundedCornerShape(10.dp))
				.background(
					if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
				)
				.padding(15.dp)) {
				Text(text = chips[it], color = TextWhite)
			}
		}
	}

}

@Composable
fun CurrentMeditation(
	color: Color = LightRed
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween,
		modifier = Modifier
			.padding(15.dp)
			.clip(RoundedCornerShape(10.dp))
			.background(color)
			.padding(
				horizontal = 15.dp,
				vertical = 20.dp
			)
			.fillMaxWidth()
	) {
		Column {
			Text(
				text = "Daily thought",
				color = TextWhite,
				style = MaterialTheme.typography
					.headlineMedium
			)
			Text(
				text = "Meditation - 3-10 min",
				color = TextWhite,
				style = MaterialTheme.typography.bodySmall
			)
		}
		Box(
			contentAlignment = Alignment.Center,
			modifier = Modifier
				.size(40.dp)
				.clip(CircleShape)
				.background(ButtonBlue)
				.padding(10.dp)
		) {
			Icon(
				painter = painterResource(id = R.drawable.ic_play),
				contentDescription = "Play",
				tint = Color.White,
				modifier = Modifier.size(16.dp)
			)
		}
	}
}

@Composable
fun FeatureSection(
	featureList: List<Feature>
) {
	Column(modifier = Modifier.fillMaxWidth()) {
		Text(
			text = "Features",
			color = TextWhite,
			style = MaterialTheme.typography.headlineMedium,
			modifier = Modifier.padding(15.dp)
		)

		LazyVerticalGrid(
			columns = GridCells.Fixed(2),
			contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
			modifier = Modifier.fillMaxHeight()
		) {
			items(featureList.size) {
				FeatureItem(feature = featureList[it])
			}
		}
	}
}

@Composable
fun FeatureItem(
	feature: Feature
) {
	BoxWithConstraints(
		modifier = Modifier
			.padding(7.5.dp)
			.aspectRatio(1f)
			.clip(RoundedCornerShape(10.dp))
			.background(feature.darkColor)
	) {
		val width = constraints.maxWidth
		val height = constraints.maxHeight

		// Medium colored path
		val mediumColorPoint1 = Offset(0f, height * 0.3f)
		val mediumColorPoint2 = Offset(width * 0.1f, height * 0.35f)
		val mediumColorPoint3 = Offset(width * 0.4f, height * 0.05f)
		val mediumColorPoint4 = Offset(width * 0.75f, height * 0.7f)
		val mediumColorPoint5 = Offset(width * 1.4f, -height.toFloat())

		val mediumColoredPath = Path().apply {
			moveTo(mediumColorPoint1.x, mediumColorPoint1.y)

			standardQuadFromTo(mediumColorPoint1, mediumColorPoint2)
			standardQuadFromTo(mediumColorPoint2, mediumColorPoint3)
			standardQuadFromTo(mediumColorPoint3, mediumColorPoint4)
			standardQuadFromTo(mediumColorPoint4, mediumColorPoint5)

			lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
			lineTo(-100f, height.toFloat() + 100f)
			close()
		}

		// Light colored path
		val lightPoint1 = Offset(0f, height * 0.35f)
		val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
		val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
		val lightPoint4 = Offset(width * 0.65f, height.toFloat())
		val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

		val lightColoredPath = Path().apply {
			moveTo(lightPoint1.x, lightPoint1.y)
			standardQuadFromTo(lightPoint1, lightPoint2)
			standardQuadFromTo(lightPoint2, lightPoint3)
			standardQuadFromTo(lightPoint3, lightPoint4)
			standardQuadFromTo(lightPoint4, lightPoint5)
			lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
			lineTo(-100f, height.toFloat() + 100f)
			close()
		}

		Canvas(modifier = Modifier.fillMaxSize()) {
			drawPath(
				path = mediumColoredPath,
				color = feature.mediumColor
			)

			drawPath(
				path = lightColoredPath,
				color = feature.lightColor
			)
		}

		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(15.dp)
		) {
			Text(
				text = feature.title,
				color = TextWhite,
				style = MaterialTheme.typography.headlineMedium,
				lineHeight = 26.sp,
				modifier = Modifier.align(Alignment.TopStart)
			)
			Icon(
				painter = painterResource(id = feature.iconId),
				contentDescription = feature.title,
				tint = Color.White,
				modifier = Modifier.align(Alignment.BottomStart)
			)
			Text(text = "Start",
				color = TextWhite,
				fontSize = 14.sp,
				fontWeight = FontWeight.Bold,
				modifier = Modifier
					.clickable {

					}
					.align(Alignment.BottomEnd)
					.clip(RoundedCornerShape(10.dp))
					.background(ButtonBlue)
					.padding(
						vertical = 6.dp,
						horizontal = 15.dp
					))
		}
	}
}