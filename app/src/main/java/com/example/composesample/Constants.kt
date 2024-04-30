package com.example.composesample

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

object Components {
	val fontFamily = FontFamily(
		Font(R.font.lexend_thin, FontWeight.Thin),
		Font(R.font.lexend_light, FontWeight.Light),
		Font(R.font.lexend_regular, FontWeight.Normal),
		Font(R.font.lexend_medium, FontWeight.Medium),
		Font(R.font.lexend_semibold, FontWeight.SemiBold),
		Font(R.font.lexend_bold, FontWeight.Bold),
		Font(R.font.lexend_extrabold, FontWeight.ExtraBold)
	)

	val Shapes = Shapes(
		small = RoundedCornerShape(4.dp),
		medium = RoundedCornerShape(4.dp),
		large = RoundedCornerShape(0.dp)
	)

	val TextWhite = Color(0xffeeeeee)
	val DeepBlue = Color(0xff06164c)
	val ButtonBlue = Color(0xff505cf3)
	val DarkerButtonBlue = Color(0xff566894)
	val LightRed = Color(0xfffc879a)
	val AquaBlue = Color(0xff9aa5c4)
	val OrangeYellow1 = Color(0xfff0bd28)
	val OrangeYellow2 = Color(0xfff1c746)
	val OrangeYellow3 = Color(0xfff4cf65)
	val Beige1 = Color(0xfffdbda1)
	val Beige2 = Color(0xfffcaf90)
	val Beige3 = Color(0xfff9a27b)
	val LightGreen1 = Color(0xff54e1b6)
	val LightGreen2 = Color(0xff36ddab)
	val LightGreen3 = Color(0xff11d79b)
	val BlueViolet1 = Color(0xffaeb4fd)
	val BlueViolet2 = Color(0xff9fa5fe)
	val BlueViolet3 = Color(0xff8f98fd)
}