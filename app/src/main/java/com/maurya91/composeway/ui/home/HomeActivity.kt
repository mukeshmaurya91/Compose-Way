package com.maurya91.composeway.ui.home

import android.os.Bundle
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextField
import androidx.ui.foundation.TextFieldValue
import androidx.ui.foundation.currentTextStyle
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.Stack
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextDecoration
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.ipx
import com.maurya91.composeway.base.BaseActivity
import com.maurya91.composeway.widgets.ColorfulAppBar

class HomeActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {

            }
        }
    }
}
@Composable
fun ExampleRow() {
    Row {
        Text("Hello World!")
        Text("Hello World!2")
    }
}
@Composable
fun ExampleColumn() {
    Column {
        Text("Hello World!")
        Text("Hello World!2")
    }
}

@Composable
fun ExampleStack() {
    Stack {
        Text("Hello World!")
        Text("Hello World!2")
    }
}
@Preview
@Composable
fun HomeScreen(){
MaterialTheme {
   Column (modifier = Modifier.fillMaxWidth()){
       ExampleRow()
       ExampleColumn()
       ExampleStack()
   }
}
}

@Composable
fun HintEditText(
    textField:TextFieldValue,
    hintText: String = "",
    modifier: Modifier = Modifier.fillMaxWidth(),
    textStyle: TextStyle = currentTextStyle()
) {
    val state = state { "" }
    val inputField = @Composable {
        TextField(
            value = textField,
            modifier = modifier,
            onValueChange = { state.value = it.text },
            textStyle = textStyle.merge(TextStyle(textDecoration = TextDecoration.None))
        )
    }

    Layout(
        children = @Composable {
            inputField()
            Text(
                text = hintText,
                modifier = modifier,
                style = textStyle.merge(TextStyle(color = Color.Gray))
            )
            Divider(color = Color.Black, thickness = 2.dp)
        },
        measureBlock = { measurables: List<Measurable>, constraints: Constraints, _ ->
            val inputFieldPlace = measurables[0].measure(constraints)
            val hintEditPlace = measurables[1].measure(constraints)
            val dividerEditPlace = measurables[2].measure(
                Constraints(constraints.minWidth, constraints.maxWidth, 2.ipx, 2.ipx)
            )
            layout(
                inputFieldPlace.width, inputFieldPlace.height + dividerEditPlace.height
            ) {
                inputFieldPlace.place(0.ipx, 0.ipx)
                if (state.value.isEmpty())
                    hintEditPlace.place(0.ipx, 0.ipx)
                dividerEditPlace.place(0.ipx, inputFieldPlace.height)
            }
        })
}