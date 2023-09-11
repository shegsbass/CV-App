package com.shegs.cvapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shegs.cvapp.viewmodel.CvViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCvScreen(navController: NavController, cvViewModel: CvViewModel) {

    var editedFullName by remember { mutableStateOf(cvViewModel.fullName) }
    var editedSlackUsername by remember { mutableStateOf(cvViewModel.slackUsername) }
    var editedGitHubHandle by remember { mutableStateOf(cvViewModel.githubHandle) }
    var editedBio by remember { mutableStateOf(cvViewModel.bio) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = editedFullName,
            onValueChange = { editedFullName = it },
            label = { Text("Full Name") }
        )

        TextField(
            value = editedBio,
            onValueChange = { editedBio = it },
            label = { Text("Enter your Bio") }
        )

        TextField(
            value = editedGitHubHandle,
            onValueChange = { editedGitHubHandle = it },
            label = { Text("Enter Github Handle") }
        )

        TextField(
            value = editedSlackUsername,
            onValueChange = { editedSlackUsername = it },
            label = { Text("Enter Slack Username") }
        )
    }

    Button(
        onClick = {
            // Update the ViewModel with edited values
            cvViewModel.fullName = editedFullName
            cvViewModel.bio = editedBio
            cvViewModel.githubHandle = editedGitHubHandle
            cvViewModel.slackUsername = editedSlackUsername

            // Navigate back to the CVView screen
            navController.navigateUp()
        },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text("Update")
    }

}