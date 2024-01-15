package com.mun.bonecci.gradienttextcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                            TextFieldExample()
                        }
                    }
                }
            }
        }
    }
}

/**
 * Returns a list of gradient colors for demonstration purposes.
 * Customize the colors based on your preferences or design requirements.
 */
fun getGradientColors(): List<Color> {
    return listOf(Color.Black, Color.Cyan, Color.Blue, Color.Green, Color.Red /*...*/)
}

/**
 * A composable function to demonstrate text rendering with a linear gradient background.
 *
 * @param previewText The text to be displayed in the example.
 */
@Composable
fun LinearGradientExample(previewText: String) {
    val brush = remember { Brush.linearGradient(colors = getGradientColors()) }
    TextWithStyle(previewText = previewText, brush)
}

/**
 * A composable function to demonstrate text rendering with a horizontal gradient background.
 *
 * @param previewText The text to be displayed in the example.
 */
@Composable
fun HorizontalGradientExample(previewText: String) {
    val brush = remember { Brush.horizontalGradient(colors = getGradientColors()) }
    TextWithStyle(previewText = previewText, brush)
}

/**
 * A composable function to demonstrate text rendering with a vertical gradient background.
 *
 * @param previewText The text to be displayed in the example.
 */
@Composable
fun VerticalGradientExample(previewText: String) {
    val brush = remember { Brush.verticalGradient(colors = getGradientColors()) }
    TextWithStyle(previewText = previewText, brush)
}

/**
 * A composable function to demonstrate text rendering with a radial gradient background.
 *
 * @param previewText The text to be displayed in the example.
 */
@Composable
fun RadialGradientExample(previewText: String) {
    val brush = remember { Brush.radialGradient(colors = getGradientColors()) }
    TextWithStyle(previewText = previewText, brush)
}

/**
 * A composable function to demonstrate text rendering with a sweep gradient background.
 *
 * @param previewText The text to be displayed in the example.
 */
@Composable
fun SweepGradientExample(previewText: String) {
    val brush = remember { Brush.sweepGradient(colors = getGradientColors()) }
    TextWithStyle(previewText = previewText, brush)
}

/**
 * A composable function to display text with specified styling and a gradient background.
 *
 * @param previewText The text to be displayed.
 * @param brush The brush defining the gradient background.
 * @param modifier The modifier for additional styling options.
 */
@Composable
fun TextWithStyle(previewText: String, brush: Brush, modifier: Modifier = Modifier) {
    val textStyle = TextStyle(
        textAlign = TextAlign.Justify,
        lineHeight = 20.sp,
        textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp),
        brush = brush
    )

    Text(
        text = previewText,
        modifier = modifier.padding(16.dp),
        style = textStyle
    )
}

/**
 * A composable function demonstrating the usage of a vertical gradient in an OutlinedTextField.
 *
 * @sample [TextFieldExample]
 */
@Composable
fun TextFieldExample() {
    // State variable to store the text input
    var text by rememberSaveable { mutableStateOf("") }

    // Create a vertical gradient brush using predefined colors
    val brush = remember { Brush.verticalGradient(colors = getGradientColors()) }

    // Define the text style with the vertical gradient
    val textStyle = TextStyle(
        textAlign = TextAlign.Justify,
        lineHeight = 20.sp,
        textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp),
        brush = brush
    )

    // OutlinedTextField composable to capture user input
    OutlinedTextField(
        value = text,
        enabled = true,
        onValueChange = { newValue ->
            text = newValue
        },
        label = { Text(text = "Gradient Example", fontSize = 14.sp, color = Color.Black) },
        textStyle = textStyle,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        maxLines = 5
    )
}



const val PREVIEW_TEXT =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
            "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor " +
            "in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur " +
            "sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est" +
            " laborum."

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
            }
        }
    }
}