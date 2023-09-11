package com.shegs.cvapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shegs.cvapp.ui.screens.CvScreen
import com.shegs.cvapp.ui.screens.EditCvScreen
import com.shegs.cvapp.viewmodel.CvViewModel

@Composable
fun AppNavigation() {

    val cvViewModel = viewModel<CvViewModel>()

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "CvScreen"){
        composable("CvScreen"){ CvScreen(navController, cvViewModel)}
        composable("editCvScreen"){ EditCvScreen(navController, cvViewModel)}
    }
}