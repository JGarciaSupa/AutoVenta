package com.lobitoconsulting.autoventa.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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