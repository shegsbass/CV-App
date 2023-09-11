package com.shegs.cvapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CvViewModel : ViewModel() {

    var firstName by mutableStateOf("Oluwasegun")
    var lastName by mutableStateOf("Oladokun")
    var slackUsername by mutableStateOf("Shegs")
    var githubHandle by mutableStateOf("Shegsbass")
    var bio by mutableStateOf("I'm a skilled and passionate software developer with a proven track record in building high-performance mobile applications. My focus is on creating innovative and user-friendly experiences that delight users. I thrive in fast-paced environments and love solving complex challenges in mobile app development. Some of my achievements include 25under25 award winner in the tech category in Nigeria (2020), winner of the Hackvote Hackathon 2018, winner of the Onehack global hackathon 2020, a Young Innovation Leaders fellow, and an African Young Leaders fellow.")
}