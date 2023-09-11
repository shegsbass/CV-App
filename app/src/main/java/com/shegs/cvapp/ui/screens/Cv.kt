package com.shegs.cvapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shegs.cvapp.viewmodel.CvViewModel

@Composable
fun CvScreen(navController: NavController) {

    val cvViewModel = viewModel<CvViewModel>()

    Text(text = cvViewModel.fullName)
    Text(text = cvViewModel.bio)
    Text(text = cvViewModel.githubHandle)
    Text(text = cvViewModel.slackUsername)
}