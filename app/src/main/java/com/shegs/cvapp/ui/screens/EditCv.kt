package com.shegs.cvapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.cvapp.R
import com.shegs.cvapp.viewmodel.CvViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCvScreen(navController: NavController, cvViewModel: CvViewModel) {

    var title by remember { mutableStateOf("CV APP") }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    var editedFirstName by remember { mutableStateOf(cvViewModel.firstName) }
    var editedLastName by remember { mutableStateOf(cvViewModel.lastName) }
    var editedSlackUsername by remember { mutableStateOf(cvViewModel.slackUsername) }
    var editedGitHubHandle by remember { mutableStateOf(cvViewModel.githubHandle) }
    var editedBio by remember { mutableStateOf(cvViewModel.bio) }

    // Create a scaffold with a top app bar
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title,
                        maxLines = 1,
                        fontSize = 24.sp,
                        letterSpacing = 0.sp,
                        fontFamily = FontFamily(Font(R.font.raleway_black)),
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(40.dp),
                                shape = RoundedCornerShape(14.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "Localized description",
                                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            }
                        }

                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                scrollBehavior = scrollBehavior
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        paddingValues = PaddingValues(
                            top = 80.dp,
                            start = 24.dp,
                            end = 24.dp,
                            bottom = 24.dp
                        )
                    )
            ) {

                item {
                    UpdateText()
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 40.dp)
                    ) {

                        val bioMaxLength = 600
                        val bioMinLength = 15
                        val maxLength = 20
                        val minLength = 3


                        Text(
                            text = "First Name",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily(Font(R.font.raleway_bold)),
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedFirstName,
                            onValueChange = { editedFirstName = it },
                            placeholder = {
                                Text(
                                    text = "Enter First Name",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedFirstName = "" }) {
                                    if (editedFirstName.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )



                        Text(
                            text = "Last Name",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily(Font(R.font.raleway_bold)),
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedLastName,
                            onValueChange = { editedLastName = it },
                            placeholder = {
                                Text(
                                    text = "Enter Last Name",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedLastName = "" }) {
                                    if (editedLastName.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )


                        Text(
                            text = "Github Handle",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily(Font(R.font.raleway_bold)),
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedGitHubHandle,
                            onValueChange = { editedGitHubHandle = it },
                            placeholder = {
                                Text(
                                    text = "Enter Github Handle",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedGitHubHandle = "" }) {
                                    if (editedGitHubHandle.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )


                        Text(
                            text = "Slack Username",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily(Font(R.font.raleway_bold)),
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedSlackUsername,
                            onValueChange = { editedSlackUsername = it },
                            placeholder = {
                                Text(
                                    text = "Enter Github Handle",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedSlackUsername = "" }) {
                                    if (editedSlackUsername.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )

                        Text(
                            text = "Your Bio",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily(Font(R.font.raleway_bold)),
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedBio,
                            onValueChange = { editedBio = it },
                            placeholder = {
                                Text(
                                    text = "Enter Github Handle",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedBio = "" }) {
                                    if (editedBio.length in bioMinLength..bioMaxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp),
                        )
                    }
                }

                item{
                    Button(
                        onClick = {
                            // Update the ViewModel with edited values
                            cvViewModel.firstName = editedFirstName
                            cvViewModel.lastName = editedLastName
                            cvViewModel.githubHandle = editedGitHubHandle
                            cvViewModel.slackUsername = editedSlackUsername
                            cvViewModel.bio = editedBio

                            // Navigate back to the CVView screen
                            navController.navigateUp()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(top = 32.dp, bottom = 24.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
                        elevation = ButtonDefaults.buttonElevation(20.dp)
                    ) {
                        Text(
                            text = "Update Cv",
                            fontFamily = FontFamily(Font(R.font.raleway_medium)),
                            fontWeight = FontWeight(300),
                            fontSize = 14.sp
                        )
                    }
                }

            }
        })

}

@Composable
fun UpdateText() {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Edit your cv",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 32.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily(Font(R.font.raleway_black)),
            modifier = Modifier
        )

        Text(
            text = "Update your Curriculum Vitae (CV) by making adjustments using the form below.",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily(Font(R.font.raleway_medium)),
            modifier = Modifier
        )
    }
}
