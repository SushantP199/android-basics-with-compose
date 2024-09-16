package com.example.composequadrant

import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  Exercise(
                      modifier = Modifier
                          .padding(innerPadding)
                  )
                }
            }
        }
    }
}

@Composable
fun Exercise(modifier: Modifier = Modifier) {
    Column {
        Row (
            modifier = Modifier
                .weight(0.5f)
        ) {
            Quadrant(
                composableType = stringResource(R.string.text_composable),
                composableDescription = stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
                color = Color(0xFFEADDFF),
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                composableType = stringResource(R.string.image_composable),
                composableDescription = stringResource(R.string.creates_a_composable_that_lays_out_and_draws_a_given_painter_class_object),
                color = Color(0xFFD0BCFF),
                modifier = Modifier
                    .weight(1f)
            )
        }
        Row (
            modifier = Modifier
                .weight(0.5f)
        ) {
            Quadrant(
                composableType = stringResource(R.string.row_composable),
                composableDescription = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_horizontal_sequence),
                color = Color(0xFFB69DF8),
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                composableType = stringResource(R.string.column_composable),
                composableDescription = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
                color = Color(0xFFF6EDFF),
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(
    composableType: String,
    composableDescription: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = composableType,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = composableDescription,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
       Exercise()
    }
}