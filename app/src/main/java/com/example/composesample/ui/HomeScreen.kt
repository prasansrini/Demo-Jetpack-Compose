package com.example.composesample.ui

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composesample.Components.ButtonBlue
import com.example.composesample.Components.DarkerButtonBlue
import com.example.composesample.Components.DeepBlue
import com.example.composesample.Components.LightRed
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
		}
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
				text = "Good morning, $name!", style = MaterialTheme.typography.headlineMedium
			)
			Text(
				text = "We wish you have a good day!", style = MaterialTheme.typography.bodySmall
			)
		}
		Icon(
			painter = painterResource(id = R.drawable.ic_search),
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
				.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
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
			.padding(horizontal = 15.dp, vertical = 20.dp)
			.fillMaxWidth()
	) {
		Column {
			Text(
				text = "Daily thought", style = MaterialTheme.typography.headlineMedium
			)
			Text(
				text = "Meditation - 3-10 min", style = MaterialTheme.typography.bodySmall
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
			style = MaterialTheme.typography.headlineMedium,
			modifier = Modifier.padding(15.dp)
		)

		LazyVerticalGrid(
			columns = GridCells.Fixed(2),
			contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
			modifier = Modifier.fillMaxHeight()
		) {
			items(featureList.size) {

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
		}
	}
}