package com.example.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composesample.components.ImageCard

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val painter = painterResource(id = R.drawable.bee)
			val description = "Green Android background"
			val title = "Android title"
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.padding(16.dp)
			) {
				ImageCard(painter = painter, contentDescription = description, title = title)
			}
		}
	}
}
