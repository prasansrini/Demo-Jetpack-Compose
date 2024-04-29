package com.example.composesample.components

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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