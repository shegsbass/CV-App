package com.shegs.cvapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shegs.cvapp.viewmodel.CvViewModel

@Composable
fun CvScreen(navController: NavController, cvViewModel: CvViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = cvViewModel.fullName)
        Text(text = cvViewModel.bio)
        Text(text = cvViewModel.githubHandle)
        Text(text = cvViewModel.slackUsername)
    }

    Button(
        onClick = {
            navController.navigate("editCvScreen")
        },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text("Edit CV")
    }
}