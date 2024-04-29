package com.example.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composesample.components.CircularProgressBar

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			Box(
				modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
			) {
				CircularProgressBar(percent = 0.4f, number = 100)
			}
		}
	}
}
