package com.example.proyectofinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
/*
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost( // FragmentContainerView
    navController = navController,
    //startDestination = Screen.LoginScreen.route,
    ) {
        //Add the screen you want to navigate
        /*addLoginScreen(navController)
        addForgotPasswordScreen()
        addHeroListScreen()*/
    }
}*/


NavHost(navController = navigator, startDestination = NavigationScreen.Home.route) {
    composable(
        route = NavigationScreen.Home.route,
        arguments = listOf()
    ) { entry ->
        val viewModel = entry.initViewModel<HomeViewModel>(navController = navigator)
        HomeScreen(
            state = viewModel.uiState,
            onCLickItem = { item ->
                navigator.navigate(NavigationScreen.Detail.createRoute(item))



                fun NavGraphBuilder.addLoginScreen(navController: NavController) {
                    composable(Screen.LoginScreen.route) {
                        LoginScreen {
                            navController.navigate(Screen.HeroListScreen.route)
                        }
                    }
                }