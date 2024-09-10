package com.fadali.activityexplorer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fadali.activityexplorer.ui.theme.ActivityExplorerTheme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            var message by remember { mutableStateOf("ThirdActivity") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp), // Add spacing between buttons
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse("https://www.medium.com")
                    }
                    context.startActivity(intent)
                }) {
                    Text("Open Medium Website")
                }

                Button(onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:example@example.com")
                        putExtra(Intent.EXTRA_SUBJECT, "Greetings!")
                        putExtra(Intent.EXTRA_TEXT, message)
                    }
                    if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    }
                }) {
                    Text("Send an Email")
                }

                Button(onClick = {
                    val shareIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Check out this amazing article!")
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                }) {
                    Text("Share Text")
                }

                Button(onClick = {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:+1234567890")
                    }
                    context.startActivity(intent)
                }) {
                    Text("Dial a Number")
                }
            }
        }
//            ActivityExplorerTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting3("Android")
//                }
//            }
    }


    override fun onStart() {
        super.onStart()
        Log.d("ActivityExplorer", "onStart  in ThirdActivity called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityExplorer", "onResume  in ThirdActivity called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityExplorer", "onPause  in ThirdActivity called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityExplorer", "onStop  in ThirdActivity called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityExplorer", "onDestroy  in ThirdActivity called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityExplorer", "onRestart  in ThirdActivity called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putInt("counter", counter) // Save the current counter value
        Log.d("ActivityExplorer", "onSaveInstanceState called - Saving state in ThirdActivity")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        counter = savedInstanceState.getInt("counter", 0) // Restore the saved counter value
        Log.d(
            "ActivityExplorer",
            "onRestoreInstanceState called - Restoring state in ThirdActivity"
        )
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "ThirdActivity $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ActivityExplorerTheme {
        Greeting3("Android")
    }
}