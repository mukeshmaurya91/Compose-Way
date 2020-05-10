package com.maurya91.composeway.ui

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.loadImageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.maurya91.composeway.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BasicComponents()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        BasicComponents()
    }
}

@Composable
fun BasicComponents() {
    val resources = ContextAmbient.current.resources
    VerticalScroller(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize() + Modifier.padding(16.dp)) {
            Title(title = "Simple Text")
            Text(text = "Hello Jetpack Compose")
//            Divider(color = Color.Gray)

            Title(title = "Styled Text")
            Text(text = "Hello Jetpack Compose", style = TextStyle(background = Color.Green))
//            Divider(color = Color.Gray)

            Title(title = "Button")
            Button(onClick = {}) {
                Text(text = "Simple Button")
            }
//            Divider(color = Color.Gray)

            Title(title = "Edit Text")
            TextField(value = TextFieldValue("input"), onValueChange = {})
            Divider(color = Color.Gray)

            Title(title = "Image")
            ImageComponent(resId = R.drawable.blue,modifier = Modifier.size(72.dp, 56.dp))
//            Box(
//                shape = RoundedCornerShape(5.dp),
//                modifier = Modifier.size(72.dp, 56.dp) + Modifier.drawBackground(
//                    color = Color.Magenta
//                )
//            ) {
//                //                Image(asset = imageResource(id = R.drawable.bg_home_gradient))
//            }
//            Divider(color = Color.Gray)
//            Title(title = "Icon")
//            val icon = imageResource(R.drawable.ic_baseline_arrow_back_24)
//            Icon(asset = icon,
//                modifier = Modifier.preferredSize(36.dp, 36.dp),
//                tint = Color.Blue)

            Title(title = "Card")
            Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
                ListItem(text = {
                    Text(text = "Title")
                }, secondaryText = {
                    Text(text = "Subtitle")
                }, icon = {
                    Box(
                        modifier = Modifier.preferredWidth(48.dp) + Modifier.preferredHeight(48.dp) + Modifier.drawBackground(
                            color = Color.Green
                        )
                    ) {
                        ImageComponent(R.drawable.blue,Modifier.preferredWidth(48.dp) + Modifier.preferredHeight(48.dp))
                        //Image(asset = imageFromResource(resources, R.drawable.bg_home_gradient))
                    }
                })
            }
//            Divider(color = Color.Gray)

            Title(title = "Circular Progress")
            CircularProgressIndicator(
                progress = 0.5f, modifier = Modifier.wrapContentWidth(
                    Alignment.CenterHorizontally
                )
            )
//            Divider(color = Color.Gray)

            Title(title = "Checkbox")
            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
//            Divider(color = Color.Gray)

            Title(title = "TriState checkbox")
            TriStateCheckboxComponent(TriStateFormState())
//            Divider(color = Color.Gray)
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        color = Color.Black,
        style = TextStyle(fontSize = 18.sp),
        modifier = Modifier.padding(top = 16.dp, bottom = 6.dp)
    )
}

@Composable
fun ImageComponent(@DrawableRes resId:Int,modifier: Modifier){
    val image = loadImageResource(resId)
    image.resource.resource?.let{
        Image(
            asset = it,
            modifier = modifier
        )
    }
}

//@Composable
//fun PreviewTemplate(
//        colors: MaterialColors = MaterialTheme.colors,
//        typography: MaterialTypography = MaterialTheme.typography
//) {
//    val context = +ambient(ContextAmbient)
//
//    MaterialTheme(colors = colors, typography = typography) {
//        Surface {
//
//        }
//    }
//}