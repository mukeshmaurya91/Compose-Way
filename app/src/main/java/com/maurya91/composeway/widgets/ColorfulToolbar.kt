package com.maurya91.composeway.widgets

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.TopAppBar
import androidx.ui.material.ripple.ripple
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.maurya91.composeway.R

@Composable
fun ColorfulToolbar(title: String, backArrow: Boolean = false, onBackArrowClicked: () -> Unit) {
    Surface(elevation = 3.dp, modifier = Modifier.fillMaxWidth() + Modifier.height(56.dp)) {
        Image(vectorResource(R.drawable.bg_home_gradient), Modifier.fillMaxSize())
        Row(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.h5)
            if (backArrow)
                BackArrow(onBackClick = onBackArrowClicked)
        }
    }

}

@Composable
fun BackArrow(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Clickable(
        modifier = Modifier.ripple(),
        onClick = { onBackClick() }
    ) {
        val image = imageResource(R.drawable.ic_baseline_arrow_back_24)
        Image(image, modifier.preferredSize(36.dp, 36.dp))
    }
}

@Composable
fun BackArrowIcon(onBackClick: () -> Unit) {
    IconButton(onClick = onBackClick) {
        Icon(vectorResource(R.drawable.ic_baseline_arrow_back_24))
    }
}


@Composable
fun ColorfulAppBar(title: String, onBackArrowClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = { BackArrowIcon(onBackClick = onBackArrowClicked) }
    )
}

@Preview
@Composable
fun PreviewColorfulToolbar() {
    MaterialTheme {
        ColorfulToolbar(title = "Sweet App", onBackArrowClicked = {})
    }
}