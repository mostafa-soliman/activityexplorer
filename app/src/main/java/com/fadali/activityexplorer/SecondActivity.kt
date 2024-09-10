package com.fadali.activityexplorer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boniantech.activityexplorer.ui.theme.ActivityExplorerTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message = intent.getStringExtra("message") ?: "No message received"
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Message received: $message",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = {
                        val intent = Intent(this@SecondActivity, MainActivity::class.java)
                        intent.putExtra("messageFromSecondActivity", "$message back from SecondActivity")
                        startActivity(intent)
                    }) {
                        Text("Previous")
                    }
                    Button(onClick = {
                        val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                        startActivity(intent)
                    }) {
                        Text("Next")
                    }
                }
            }
//            {
//                Text(text = "Message received: $message", style = MaterialTheme.typography.headlineMedium)
//            }
//            ActivityExplorerTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting2("Android")
//                }
//            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("ActivityExplorer", "onStart in SecondActivity called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityExplorer", "onResume in SecondActivity called")
    }
    override fun onPause() {
        super.onPause()
        Log.d("ActivityExplorer", "onPause in SecondActivity called")
    }
    override fun onStop() {
        super.onStop()
        Log.d("ActivityExplorer", "onStop in SecondActivity called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityExplorer", "onDestroy in SecondActivity called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityExplorer", "onRestart in SecondActivity called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putInt("counter", counter) // Save the current counter value
        Log.d("ActivityExplorer", "onSaveInstanceState called - Saving state in SecondActivity")
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        counter = savedInstanceState.getInt("counter", 0) // Restore the saved counter value
        Log.d("ActivityExplorer", "onRestoreInstanceState called - Restoring state in SecondActivity")
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "SecondActivity $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ActivityExplorerTheme {
        Greeting2("Android")
    }
}