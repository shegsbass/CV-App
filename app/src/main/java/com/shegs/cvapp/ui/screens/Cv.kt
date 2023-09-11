package com.shegs.cvapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.cvapp.R
import com.shegs.cvapp.viewmodel.CvViewModel

@Composable
fun CvScreen(navController: NavController, cvViewModel: CvViewModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        item {
            NameSection(cvViewModel)
        }
        item {
            BioSection(cvViewModel)
        }
        item {
            HandleSection(cvViewModel)
        }
        item {
            EditButton(navController)
        }
    }
}

@Composable
fun NameSection(cvViewModel: CvViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.Black, RoundedCornerShape(20.dp))
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                contentAlignment = Alignment.TopEnd

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = "Avatar",
                    tint = Color.White.copy(alpha = 0.9f),
                    modifier = Modifier
                        .size(170.dp)
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.avatar
                    ),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(170.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = "I'am,",
                        color = Color.White,
                        fontSize = 32.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily(Font(R.font.raleway_light)),
                        modifier = Modifier
                    )
                    Text(
                        text = cvViewModel.firstName,
                        color = Color.White,
                        fontSize = 32.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily(Font(R.font.raleway_bold)),
                        modifier = Modifier
                    )
                    Text(
                        text = cvViewModel.lastName,
                        color = Color.White,
                        fontSize = 32.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily(Font(R.font.raleway_bold)),
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BioSection(cvViewModel: CvViewModel) {
    Column(
        modifier = Modifier
            .padding(top = 24.dp)
    ) {
        Text(
            text = "About Me",
            fontSize = 32.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily(Font(R.font.raleway_bold)),
            modifier = Modifier
        )

        val maxLines = 4 // Maximum number of lines to display initially

        var expanded by remember { mutableStateOf(false) }

        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontFamily = FontFamily(Font(R.font.raleway_regular)))) {
                val maxLines = if (expanded) Int.MAX_VALUE else 4 // Maximum number of lines to display initially
                val textToShow = if (cvViewModel.bio.length > maxLines * 25) {
                    cvViewModel.bio.substring(0, maxLines * 25)
                } else {
                    cvViewModel.bio
                }
                append(textToShow)
                if (cvViewModel.bio.length > maxLines * 25) {
                    // Add a "Read more" link at the end
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.None, color = Color.Magenta)) {
                        append("... Read more")
                    }
                }
            }
        }

        Text(
            text = text,
            fontSize = 16.sp,
            maxLines = if (expanded) Int.MAX_VALUE else maxLines,
            letterSpacing = 0.sp,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily(Font(R.font.raleway_regular)),
            modifier = Modifier.clickable { expanded = !expanded }
        )
    }
}

@Composable
fun HandleSection(cvViewModel: CvViewModel) {
    Row(
        modifier = Modifier
            .padding(top = 24.dp)
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.slack),
                contentDescription = "Slack Handle",
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = cvViewModel.slackUsername,
                fontSize = 16.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily(Font(R.font.raleway_bold)),
                modifier = Modifier
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.github_logo),
                contentDescription = "Github Handle",
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = cvViewModel.githubHandle,
                fontSize = 16.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily(Font(R.font.raleway_bold)),
                modifier = Modifier
            )
        }
    }
}

@Composable
fun EditButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("editCvScreen")
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .padding(top = 32.dp, bottom = 24.dp)
    ) {
        Text("Edit CV")
    }
}