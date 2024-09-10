package com.fadali.activityexplorer

import com.fadali.activityexplorer.ui.theme.ActivityExplorerTheme


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fadali.activityexplorer.ui.theme.ActivityExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityExplorer", "onStart called")

        setContent {
            var message by remember { mutableStateOf("") }
            val messageFromSecondActivity = intent.getStringExtra("messageFromSecondActivity") ?: " "

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    label = { Text("Enter your message") },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = messageFromSecondActivity)
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("message", message)
                    startActivity(intent)
                }) {
                    Text("Send to SecondActivity")
                }
            }
//            ActivityExplorerTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityExplorer", "onStart in MainActivity called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityExplorer", "onResume in MainActivity called")
    }
    override fun onPause() {
        super.onPause()
        Log.d("ActivityExplorer", "onPause in MainActivity called")
    }
    override fun onStop() {
        super.onStop()
        Log.d("ActivityExplorer", "onStop in MainActivity called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityExplorer", "onDestroy in MainActivity called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityExplorer", "onRestart in MainActivity called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putInt("counter", counter) // Save the current counter value
        Log.d("ActivityExplorer", "onSaveInstanceState called - Saving state in MainActivity")
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        counter = savedInstanceState.getInt("counter", 0) // Restore the saved counter value
        Log.d("ActivityExplorer", "onRestoreInstanceState called - Restoring state in MainActivity")
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "MainActivity $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActivityExplorerTheme {
        Greeting("Android")
    }
}