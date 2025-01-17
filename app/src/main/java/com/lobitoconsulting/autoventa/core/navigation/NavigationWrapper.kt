package com.lobitoconsulting.autoventa.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.lobitoconsulting.autoventa.core.HomeScreen
import com.lobitoconsulting.autoventa.core.LoginScreen
import com.lobitoconsulting.autoventa.core.SplashScreen
import com.lobitoconsulting.autoventa.ui.login.LoginScreen
import com.lobitoconsulting.autoventa.ui.splash.SplashScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SplashScreen) {
//        composable<Login> {
//            LoginScreen {
////                navController.navigate(Home)
//            }
//        }

        composable<SplashScreen> {
            SplashScreen(
                onNavigate = {
                    navController.navigate(LoginScreen){
                        defaultNavOptions(navController)
                    }
                }
            )
        }
        composable<LoginScreen> {
            LoginScreen(
                onNavigate = {
                    navController.navigate(HomeScreen){
                        defaultNavOptions(navController)
                    }
                }
            )
        }


//        composable<Home> {
//            HomeScreen { name -> navController.navigate(Detail(name = name)) }
//        }

//        composable<Detail> { backStackEntry ->
//            val detail: Detail = backStackEntry.toRoute()
//            DetailScreen(name = detail.name,
////                navigateBack = { navController.navigateUp() },
//                navigateBack = { navController.navigate(Login){popUpTo<Login>{inclusive = true}} }, // se retorna y elimina la pila de navegación hasta el login
//                navigateToSettings = {navController.navigate(Settings(it))})
//        }
//
//        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to createNavType<SettingsInfo>())){ backStackEntry ->
//            val settings:Settings = backStackEntry.toRoute()
//            SettingsScreen(settings.info)
//        }
    }
}