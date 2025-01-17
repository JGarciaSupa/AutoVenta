package com.lobitoconsulting.autoventa.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lobitoconsulting.autoventa.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigate: () -> Unit
) {
    val alpha = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        alpha.animateTo(1f,
            animationSpec = tween(1500)
        )
        delay(2000)
        onNavigate()

    }
    Splash(alphaValue = alpha.value)

}
@Composable
fun Splash(alphaValue: Float) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFFF6A00)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(450.dp,450.dp).alpha(alphaValue),
            painter = painterResource(id = R.drawable.logosplash), contentDescription = "Logo")
        Text(
            text = "Lobito Consulting",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenView(){
    Splash(alphaValue = 1f) // Aquí proporcionamos un valor fijo de alpha para la vista previa
}