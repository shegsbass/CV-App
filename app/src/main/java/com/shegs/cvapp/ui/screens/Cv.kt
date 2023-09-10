package com.shegs.cvapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.shegs.cvapp.viewmodel.CvViewModel

@Composable
fun CvScreen(cvViewModel: CvViewModel) {

    Text(text = cvViewModel.fullName)
    Text(text = cvViewModel.bio)
    Text(text = cvViewModel.githubHandle)
    Text(text = cvViewModel.slackUsername)
}