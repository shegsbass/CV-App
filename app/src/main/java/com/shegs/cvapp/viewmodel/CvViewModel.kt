package com.shegs.cvapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CvViewModel : ViewModel() {

    var fullName by mutableStateOf("Your Full Name")
    var slackUsername by mutableStateOf("Your Slack Username")
    var githubHandle by mutableStateOf("Your Github Handle")
    var bio by mutableStateOf("Your Bio")
}