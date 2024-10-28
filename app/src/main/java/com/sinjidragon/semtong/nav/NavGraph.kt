package com.sinjidragon.semtong.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sinjidragon.semtong.auth.ui.view.FirstView
import com.sinjidragon.semtong.auth.ui.view.LoginView
import com.sinjidragon.semtong.auth.ui.view.SignupView.GetEmailView
import com.sinjidragon.semtong.auth.ui.view.SignupView.GetIdPasswordView
import com.sinjidragon.semtong.group.ui.view.GroupView
import com.sinjidragon.semtong.group.ui.view.JoinGroupView
import com.sinjidragon.semtong.main.ui.screen.GiveMeMoneyView
import com.sinjidragon.semtong.main.ui.screen.GoalView
import com.sinjidragon.semtong.main.ui.screen.HomeView
import com.sinjidragon.semtong.main.ui.screen.ProfileView
import com.sinjidragon.semtong.main.ui.screen.SemtongView

@Composable
fun NavGraph(navController: NavHostController) {
    val startDestination = NavGroup.FIRST

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = NavGroup.FIRST) {
            FirstView(navController = navController)
        }
        composable(route = NavGroup.LOGIN + "/{showAlert}") {
            val showAlert = it.arguments?.getString("showAlert")?.toBoolean() ?: false
            LoginView(navController = navController, showAlert = showAlert)
        }
        composable(route = NavGroup.SIGNUP_ID_PASSWORD) {
            GetIdPasswordView(navController = navController)
        }
        composable(route = NavGroup.SIGNUP_EMAIL+"/{idText}/{passwordText}") { backStackEntry ->
            val idText = backStackEntry.arguments?.getString("idText") ?: ""
            val passwordText = backStackEntry.arguments?.getString("passwordText") ?: ""
            GetEmailView(navController = navController,idText = idText, passwordText = passwordText)
        }
        composable(route = NavGroup.GROUP) {
            GroupView(navController = navController)
        }
        composable(route = NavGroup.GROUP_JOIN+"/{groupName}/{groupCode}") {
            val groupName = it.arguments?.getString("groupName") ?: ""
            val groupCode = it.arguments?.getString("groupCode") ?: ""
            JoinGroupView(navController = navController,groupName = groupName, groupCode = groupCode)
        }
        composable(route = NavGroup.HOME) {
            HomeView(navController = navController)
        }
        composable(route = NavGroup.GOAL) {
            GoalView(navController = navController)
        }
        composable(route = NavGroup.PROFILE) {
            ProfileView(navController = navController)
        }
        composable(route = NavGroup.GIVE_ME_MONEY) {
            GiveMeMoneyView(navController = navController)
        }
        composable(route = NavGroup.SEMTONG) {
            SemtongView(navController = navController)
        }
    }

}