package com.example.composesample.components

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun ImageCard(
	painter: Painter, contentDescription: String, title: String, modifier: Modifier = Modifier
) {
	Card(
		modifier = modifier
			.fillMaxWidth()
			.clickable { },
		shape = RoundedCornerShape(15.dp),
		elevation = CardDefaults.cardElevation(5.dp)
	) {
		Box(modifier = Modifier.height(200.dp)) {
			Image(
				painter = painter,
				contentDescription = contentDescription,
				contentScale = ContentScale.Crop
			)
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(
						brush = Brush.verticalGradient(
							colors = listOf(
								Color.Transparent, Color.Black
							), startY = 300f
						)
					)
			)
			Box(
				modifier = Modifier
					.fillMaxSize()
					.padding(12.dp),
				contentAlignment = Alignment.BottomStart
			) {
				Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
			}
		}
	}
}

@Composable
fun TextStyling(fontFamily: FontFamily) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(
				Color(0xFF101010)
			)
	) {
		Text(
			text = buildAnnotatedString {
				withStyle(
					style = SpanStyle(
						color = Color.Green, fontSize = 50.sp
					)
				) {
					append("J")
				}
				append("etpack")
				withStyle(
					style = SpanStyle(
						color = Color.Green, fontSize = 50.sp
					)
				) {
					append("C")
				}
				append("ompose")
			},
			color = Color.White,
			fontSize = 30.sp,
			fontFamily = fontFamily,
			fontWeight = FontWeight.Bold,
			fontStyle = FontStyle.Italic,
			textAlign = TextAlign.Center,
			textDecoration = TextDecoration.Underline
		)
	}
}

@Composable
fun ColorBoxSetContent() {
	Column(modifier = Modifier.fillMaxSize()) {
		val color = remember {
			mutableStateOf(Color.Yellow)
		}

		ColorBox(
			modifier = Modifier
				.weight(1f)
				.fillMaxSize()
		) {
			color.value = it
		}

		Box(
			modifier = Modifier
				.background(color.value)
				.weight(1f)
				.fillMaxSize()
		)
	}
}

@Composable
fun ColorBox(
	modifier: Modifier = Modifier, updateColor: (Color) -> Unit
) {

	Box(modifier = modifier
		.background(Color.Red)
		.clickable {
			updateColor(
				Color(
					Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f
				)
			)
		})
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SnackHandler() {
	val snackBarHostState = remember {
		SnackbarHostState()
	}

	var textFieldState by remember {
		mutableStateOf("")
	}

	val scope = rememberCoroutineScope()

	Scaffold(snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
			modifier = Modifier
				.fillMaxSize()
				.padding(horizontal = 30.dp)
		) {
			OutlinedTextField(value = textFieldState, label = {
				Text(
					text = "Enter your name."
				)
			}, onValueChange = {
				textFieldState = it
			}, singleLine = true, modifier = Modifier.fillMaxWidth()
			)
			Spacer(modifier = Modifier.height(16.dp))
			Button(onClick = {
				scope.launch {
					snackBarHostState.showSnackbar("Hello $textFieldState")
				}
			}) {
				Text("Please greet me!")
			}
		}
	}
}

@Composable
fun ScrollableList() {
	val scrollState = rememberScrollState()

	Column(modifier = Modifier.verticalScroll(state = scrollState)) {
		for (i in 1..50) {
			Text(
				text = "Item $i",
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold,
				textAlign = TextAlign.Center,
				modifier = Modifier
					.fillMaxWidth()
					.padding(24.dp)
			)
		}
	}
}

@Composable
fun LazyScrollableList() {
	LazyColumn {
		itemsIndexed(
			listOf("This", "is", "Jetpack", "Compose")
		) { index, string ->
			Text(
				text = string,
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold,
				textAlign = TextAlign.Center,
				modifier = Modifier
					.fillMaxWidth()
					.padding(24.dp)
			)
		}

		items(50) {
			Text(
				text = "$it",
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold,
				textAlign = TextAlign.Center,
				modifier = Modifier
					.fillMaxWidth()
					.padding(24.dp)
			)
		}
	}
}

@Composable
fun ConstraintLayoutDemo() {
	val constraints = ConstraintSet {
		val greenBox = createRefFor("greenbox")
		val redBox = createRefFor("redbox")
		val guideLine = createGuidelineFromTop(0.5f)

		constrain(greenBox) {
			top.linkTo(guideLine)
			start.linkTo(parent.start)
			width = Dimension.value(100.dp)
			height = Dimension.value(100.dp)
		}

		constrain(redBox) {
			top.linkTo(parent.top)
			start.linkTo(greenBox.end)
			end.linkTo(parent.end)
			width = Dimension.value(100.dp)
			height = Dimension.value(100.dp)
		}
		createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
	}

	ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
		Box(
			modifier = Modifier
				.background(Color.Green)
				.layoutId("greenbox")
		)

		Box(
			modifier = Modifier
				.background(Color.Red)
				.layoutId("redbox")
		)
	}
}

@Composable
fun AnimationStyle() {
	var sizeState by remember { mutableStateOf(200.dp) }

	val size by animateDpAsState(
		targetValue = sizeState, label = "", animationSpec = tween(
			durationMillis = 3000, delayMillis = 300, easing = LinearOutSlowInEasing
		)
	)

	val infiniteTransition = rememberInfiniteTransition()
	val color by infiniteTransition.animateColor(
		initialValue = Color.Red, targetValue = Color.Green, animationSpec = infiniteRepeatable(
			tween(durationMillis = 2000), repeatMode = RepeatMode.Reverse
		), label = ""
	)


	val sizeUsingSpring by animateDpAsState(
		targetValue = sizeState, label = "", animationSpec = spring(
			Spring.DampingRatioHighBouncy
		)
	)

	val sizeUsingKeyFrames by animateDpAsState(
		targetValue = sizeState,
		label = "",
		animationSpec = keyframes {
			durationMillis = 5000
			sizeState at 0 with LinearEasing
			sizeState * 1.5f at 1000 with FastOutLinearInEasing
			sizeState * 2f at 5000
		})

	Box(
		modifier = Modifier
			.size(size)
			.background(color), contentAlignment = Alignment.Center
	) {
		Button(onClick = {
			sizeState += 50.dp
		}) {
			Text(text = "Increase size!")
		}
	}
}

@Composable
fun CircularProgressBar(
	percent: Float,
	number: Int,
	fontSize: TextUnit = 28.sp,
	radius: Dp = 50.dp,
	color: Color = Color.Gray,
	strokeWidth: Dp = 8.dp,
	animationDuration: Int = 1000,
	animationDelay: Int = 0
) {
	var animationPlayed by remember {
		mutableStateOf(false)
	}

	val currentPercentage = animateFloatAsState(
		targetValue = if (animationPlayed) percent else 0f, animationSpec = tween(
			durationMillis = animationDuration, delayMillis = animationDelay
		), label = ""
	)

	LaunchedEffect(key1 = true) {
		animationPlayed = true
	}

	Box(
		modifier = Modifier.size(radius * 2f), contentAlignment = Alignment.Center
	) {
		Canvas(modifier = Modifier.size(radius * 2f)) {
			drawArc(
				color = color,
				-90f,
				360 * currentPercentage.value,
				useCenter = false,
				style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
			)
		}

		Text(
			text = (currentPercentage.value * number).toInt().toString() + "%",
			color = Color.Black,
			fontSize = fontSize,
			fontWeight = FontWeight.Bold
		)
	}
}
