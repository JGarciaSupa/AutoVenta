package com.lobitoconsulting.autoventa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.lobitoconsulting.autoventa.core.navigation.NavigationWrapper
import com.lobitoconsulting.autoventa.ui.theme.AutoVentaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoVentaTheme {
                NavigationWrapper()
            }
        }
    }
}