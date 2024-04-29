package com.example.composesample.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
