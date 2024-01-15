package com.mun.bonecci.gradienttextcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mun.bonecci.gradienttextcomponent.Gradient.HorizontalGradientExample
import com.mun.bonecci.gradienttextcomponent.Gradient.LinearGradientExample
import com.mun.bonecci.gradienttextcomponent.Gradient.OutlinedTextFieldExample
import com.mun.bonecci.gradienttextcomponent.Gradient.PREVIEW_TEXT
import com.mun.bonecci.gradienttextcomponent.Gradient.RadialGradientExample
import com.mun.bonecci.gradienttextcomponent.Gradient.SweepGradientExample
import com.mun.bonecci.gradienttextcomponent.Gradient.VerticalGradientExample
import com.mun.bonecci.gradienttextcomponent.ui.theme.GradientTextComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientTextComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(modifier = Modifier.padding(16.dp)) {
                        item {
                            LinearGradientExample(previewText = PREVIEW_TEXT)
                            HorizontalGradientExample(previewText = PREVIEW_TEXT)
                            VerticalGradientExample(previewText = PREVIEW_TEXT)
                            RadialGradientExample(previewText = PREVIEW_TEXT)
                            SweepGradientExample(previewText = PREVIEW_TEXT)
                            OutlinedTextFieldExample()
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GradientTextComponentTheme {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            item {
                LinearGradientExample(previewText = PREVIEW_TEXT)
                HorizontalGradientExample(previewText = PREVIEW_TEXT)
                VerticalGradientExample(previewText = PREVIEW_TEXT)
                RadialGradientExample(previewText = PREVIEW_TEXT)
                SweepGradientExample(previewText = PREVIEW_TEXT)
                OutlinedTextFieldExample()
            }
        }
    }
}