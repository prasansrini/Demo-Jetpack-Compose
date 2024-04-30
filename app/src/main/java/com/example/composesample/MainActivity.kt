package com.example.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composesample.components.MusicKnob
import com.example.composesample.components.VolumeBar
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			Box(
				contentAlignment = Alignment.Center,
				modifier = Modifier
					.fillMaxSize()
					.background(Color(0xFF101010))
			) {
				Row(
					horizontalArrangement = Arrangement.Center,
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.border(1.dp, Color.Green, RoundedCornerShape(10.dp))
						.padding(30.dp)
				) {
					var volume by remember {
						mutableStateOf(0f)
					}

					val barCount = 20

					MusicKnob(
						modifier = Modifier.size(100.dp)
					) {
						volume = it
					}
					Spacer(modifier = Modifier.width(20.dp))
					VolumeBar(
						modifier = Modifier
							.fillMaxWidth()
							.height(30.dp),
						activeBars = (barCount * volume).roundToInt(),
						barCount = barCount

					)
				}
			}
		}
	}
}
