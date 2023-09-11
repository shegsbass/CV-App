package com.shegs.cvapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CvViewModel : ViewModel() {

    var fullName by mutableStateOf("Oladokun Oluwasegun")
    var slackUsername by mutableStateOf("Shegs")
    var githubHandle by mutableStateOf("Shegsbass")
    var bio by mutableStateOf("I am a Mobile Developer")
}