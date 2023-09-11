package com.shegs.cvapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CvScreen(navController: NavController, cvViewModel: CvViewModel) {

    var title by remember { mutableStateOf("CV APP") }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    // Create a scaffold with a top app bar
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = title,
                    maxLines = 1,
                    fontSize = 24.sp,
                    letterSpacing = 0.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_black)),
                    overflow = TextOverflow.Ellipsis
                ) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                scrollBehavior = scrollBehavior
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = PaddingValues(top = 45.dp, bottom = 24.dp,))
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
        })
}

@Composable
fun NameSection(cvViewModel: CvViewModel) {

    val bounceAnimation = rememberInfiniteTransition()
    val translateY by bounceAnimation.animateFloat(
        initialValue = -16f,
        targetValue = 16f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "Animation"
    )

    val scaleAnimation = rememberInfiniteTransition()
    val scale by scaleAnimation.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(MaterialTheme.colorScheme.onPrimaryContainer, RoundedCornerShape(bottomEnd = 100.dp))
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
                    contentDescription = "Circle",
                    tint = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                    modifier = Modifier
                        .size(160.dp)
                        .scale(scale)

                )
                Image(
                    painter = painterResource(
                        id = R.drawable.avt
                    ),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(160.dp)
                        .graphicsLayer {
                            translationY = translateY // Apply translationY to the icon
                        }
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
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        fontSize = 32.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily(Font(R.font.rubik_light)),
                        modifier = Modifier
                    )
                    Text(
                        text = cvViewModel.firstName,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 36.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily(Font(R.font.rubik_bold)),
                        modifier = Modifier
                    )
                    Text(
                        text = cvViewModel.lastName,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 36.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily(Font(R.font.rubik_bold)),
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
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = "About Me",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 32.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily(Font(R.font.rubik_bold)),
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
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.None, color = MaterialTheme.colorScheme.primaryContainer)) {
                        append("... Read more")
                    }
                }
            }
        }

        Text(
            text = text,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = if (expanded) Int.MAX_VALUE else maxLines,
            letterSpacing = 0.sp,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily(Font(R.font.rubik_medium)),
            modifier = Modifier.clickable { expanded = !expanded }
        )
    }
}

@Composable
fun HandleSection(cvViewModel: CvViewModel) {
    Row(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
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
                fontFamily = FontFamily(Font(R.font.rubik_bold)),
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
                fontFamily = FontFamily(Font(R.font.rubik_bold)),
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
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .padding(top = 32.dp, bottom = 24.dp, start = 24.dp, end = 24.dp),
        elevation = ButtonDefaults.buttonElevation(20.dp)
    ) {
        Text(
            text = "Edit CV",
            fontSize = 16.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.rubik_bold))

        )
    }
}