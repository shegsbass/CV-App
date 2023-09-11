package com.shegs.cvapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shegs.cvapp.viewmodel.CvViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCvScreen(navController: NavController) {

    val cvViewModel = viewModel<CvViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = cvViewModel.fullName,
            onValueChange = { cvViewModel.fullName = it }
        )

        TextField(
            value = cvViewModel.bio,
            onValueChange = { cvViewModel.bio = it }
        )

        TextField(
            value = cvViewModel.githubHandle,
            onValueChange = { cvViewModel.githubHandle = it }
        )

        TextField(
            value = cvViewModel.slackUsername,
            onValueChange = { cvViewModel.slackUsername = it }
        )
    }

}