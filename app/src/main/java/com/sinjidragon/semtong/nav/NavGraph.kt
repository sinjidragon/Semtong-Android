package com.sinjidragon.semtong.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sinjidragon.semtong.auth.ui.screen.IntroScreen
import com.sinjidragon.semtong.auth.ui.screen.LoginScreen
import com.sinjidragon.semtong.auth.ui.screen.SignupScreen.SignupScreen1
import com.sinjidragon.semtong.auth.ui.screen.SignupScreen.SignupScreen2

@Composable
fun NavGraph(navController: NavHostController) {
    val startDestination = NavGroup.INTRO

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = NavGroup.INTRO) {
            IntroScreen(navController = navController)
        }
        composable(route = NavGroup.LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(route = NavGroup.SIGNUP1) {
            SignupScreen1(navController = navController)
        }
        composable(route = NavGroup.SIGNUP2) {
            SignupScreen2(navController = navController)
        }
    }

}