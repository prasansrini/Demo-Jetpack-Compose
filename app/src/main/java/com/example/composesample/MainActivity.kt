package com.example.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composesample.components.ColorBox

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
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
	}
}
