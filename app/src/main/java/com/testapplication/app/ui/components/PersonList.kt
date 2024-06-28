package com.testapplication.app.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import apolloClient
import com.testapplication.app.GetPeopleQuery


@Composable
fun PersonList(onPersonSelected: (GetPeopleQuery.Person) -> Unit) {
    var personList by remember { mutableStateOf(emptyList<GetPeopleQuery.Person>()) }
    LaunchedEffect(Unit) {
        val response = apolloClient.query(GetPeopleQuery()).execute()
        personList = response.data?.allPeople?.people?.filterNotNull() ?: emptyList()
    }

    LazyColumn {
        items(personList) { person ->
            PersonItem(person, onPersonSelected)
            HorizontalDivider(color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}
