package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                    Body(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Body(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(R.string.lemon_tree) }

    var tapCount = 0

    val tapRequired = (2..4).random()

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if(step.equals(R.string.lemon)) {
                    if(tapCount == tapRequired) {
                        step = when (step) {
                            R.string.lemon_tree -> R.string.lemon
                            R.string.lemon -> R.string.glass_of_lemonade
                            R.string.glass_of_lemonade -> R.string.empty_glass
                            else -> R.string.lemon_tree
                        }
                    } else {
                        tapCount++;
                    }
                } else {
                    step = when (step) {
                        R.string.lemon_tree -> R.string.lemon
                        R.string.lemon -> R.string.glass_of_lemonade
                        R.string.glass_of_lemonade -> R.string.empty_glass
                        else -> R.string.lemon_tree
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2)),
            shape = RoundedCornerShape(40.dp),
            border = BorderStroke(2.dp, color = Color(105, 205, 216)),
            modifier = Modifier
                .size(200.dp)
        )  {
            Image(
                painter = painterResource(id = when (step) {
                    R.string.lemon_tree -> R.drawable.lemon_tree
                    R.string.lemon -> R.drawable.lemon_squeeze
                    R.string.glass_of_lemonade -> R.drawable.lemon_drink
                    else -> R.drawable.lemon_restart
                }),
                contentDescription = stringResource(id = when (step) {
                    R.string.lemon_tree -> R.string.tap_the_lemonade_to_drink_it
                    R.string.lemon -> R.string.keep_tapping_the_lemon_to_squeeze_it
                    R.string.glass_of_lemonade -> R.string.tap_the_lemonade_to_drink_it
                    else -> R.string.tap_the_empty_glass_to_start_again
                }),
                modifier = Modifier
                    .padding(10.dp)
                ,
                contentScale = ContentScale.Fit,
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(
                id = when (step) {
                    R.string.lemon_tree -> R.string.tap_the_lemonade_to_drink_it
                    R.string.lemon -> R.string.keep_tapping_the_lemon_to_squeeze_it
                    R.string.glass_of_lemonade -> R.string.tap_the_lemonade_to_drink_it
                    else -> R.string.tap_the_empty_glass_to_start_again
                }
            ),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Body(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}