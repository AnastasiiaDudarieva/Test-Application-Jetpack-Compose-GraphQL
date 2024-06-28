package com.testapplication.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import apolloClient
import com.apollographql.apollo3.api.Optional
import com.testapplication.app.GetPersonQuery
import com.testapplication.app.R
import com.testapplication.app.ui.components.PersonDetailSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, personId: String, personName: String) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var personData by remember { mutableStateOf<GetPersonQuery.Person?>(null) }

    val coroutineScope = rememberCoroutineScope()

    Column {
        TopAppBar(
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            title = { Text(text = stringResource(R.string.people)) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            val text = stringResource(R.string.detail_screen_text, personName)

            val annotatedString = buildAnnotatedString {
                append(text)
                addStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 18.sp
                    ),
                    start = text.indexOf("here"),
                    end = text.indexOf("here") + "here".length
                )
                addStringAnnotation(
                    tag = "Link",
                    annotation = personId,
                    start = text.indexOf("here"),
                    end = text.indexOf("here") + "here".length
                )
            }

            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations("Link", offset, offset)
                        .firstOrNull()?.let { annotation ->
                            coroutineScope.launch {
                                try {
                                    val response = apolloClient.query(
                                        GetPersonQuery(
                                            Optional.present(annotation.item)
                                        )
                                    ).execute()
                                    val person = response.data?.person
                                    if (person != null) {
                                        personData = person
                                        showBottomSheet = true
                                    }
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                        }
                },
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
            )
        }
    }

    if (showBottomSheet && personData != null) {
        PersonDetailSheet(
            person = personData!!,
            onDismissRequest = { showBottomSheet = false }
        )
    }
}
