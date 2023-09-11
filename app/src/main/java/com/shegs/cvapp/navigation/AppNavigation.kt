package com.shegs.cvapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shegs.cvapp.ui.screens.CvScreen
import com.shegs.cvapp.ui.screens.EditCvScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "CvScreen"){
        composable("CvScreen"){ CvScreen(navController)}
        composable("editCvScreen"){ EditCvScreen(navController)}
    }


}