package com.sinjidragon.semtong.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sinjidragon.semtong.auth.ui.screen.FirstView
import com.sinjidragon.semtong.auth.ui.screen.LoginView
import com.sinjidragon.semtong.auth.ui.screen.SignupScreen.GetEmailView
import com.sinjidragon.semtong.auth.ui.screen.SignupScreen.GetIdPasswordView

@Composable
fun NavGraph(navController: NavHostController) {
    val startDestination = NavGroup.FIRST

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = NavGroup.FIRST) {
            FirstView(navController = navController)
        }
        composable(route = NavGroup.LOGIN) {
            LoginView(navController = navController)
        }
        composable(route = NavGroup.SIGNUP_ID_PASSWORD) {
            GetIdPasswordView(navController = navController)
        }
        composable(route = NavGroup.SIGNUP_EMAIL+"/{idText}/{passwordText}") { backStackEntry ->
            val idText = backStackEntry.arguments?.getString("idText") ?: ""
            val passwordText = backStackEntry.arguments?.getString("passwordText") ?: ""
            GetEmailView(navController = navController,idText = idText, passwordText = passwordText)
        }
    }

}