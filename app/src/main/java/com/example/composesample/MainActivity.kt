package com.example.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composesample.ui.HomeScreen
import com.example.composesample.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			ComposeSampleTheme {
				HomeScreen()
			}
		}
	}
}
