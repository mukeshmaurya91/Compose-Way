package com.maurya91.composeway.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.compose.Composable
import androidx.core.os.postDelayed
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Paint
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.size
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.maurya91.composeway.base.BaseActivity
import com.maurya91.composeway.ui.MainActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SplashComponent()
            }
        }
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        },2000)
    }
}

@Composable
fun SplashComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.size(72.dp, 56.dp) +
                    Modifier.drawBackground(
                        color = Color.Magenta
                    )
        )
    }
}


@Preview
@Composable
fun SplashComponentPreview() {
    MaterialTheme {

    }
}