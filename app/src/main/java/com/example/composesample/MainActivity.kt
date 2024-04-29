package com.example.composesample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			Column(
				modifier = Modifier
					.background(Color.Green)
					.fillMaxHeight(0.5f)
					.fillMaxWidth()
					.border(4.dp, Color.Blue)
					.padding(5.dp)
					.border(5.dp, Color.Gray)
					.padding(10.dp)
					.border(10.dp, Color.Black)
					.padding(10.dp)
			) {
				Text(
					text = "Hello",
					modifier = Modifier
						.border(5.dp, Color.Red)
						.padding(5.dp)
						.offset(20.dp, 20.dp)
						.border(10.dp, Color.Black)
						.padding(10.dp)
				)
				Spacer(modifier = Modifier.height(50.dp))
				Text(text = "World!", modifier = Modifier.clickable {
					Toast.makeText(
						this@MainActivity, "Hello", Toast.LENGTH_SHORT
					).show()
					Log.e("MainActivity", "Hello")
				})
			}
		}
	}
}
