package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
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
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Quadrant(
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun EachQuadrant(title: String, content: String, modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(
                        bottom = 16.dp
                    )
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            EachQuadrant(
                title = stringResource(R.string.quad1_title),
                content = stringResource(R.string.quad1_text),
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFEADDFF))
                    .fillMaxSize()
            )
            EachQuadrant(
                title = stringResource(R.string.quad2_title),
                content = stringResource(R.string.quad2_text),
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFD0BCFF))
                    .fillMaxSize()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            EachQuadrant(
                title = stringResource(R.string.quad3_title),
                content = stringResource(R.string.quad3_text),
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFB69DF8))
                    .fillMaxSize()
            )
            EachQuadrant(
                title = stringResource(R.string.quad3_title),
                content = stringResource(R.string.quad3_text),
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFF6EDFF))
                    .fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        Quadrant(
            modifier = Modifier
        )
    }
}