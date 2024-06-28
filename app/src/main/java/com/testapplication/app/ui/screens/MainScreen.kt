package com.testapplication.app.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.testapplication.app.GetPeopleQuery
import com.testapplication.app.R
import com.testapplication.app.ui.components.PersonList

@Composable
fun MainScreen(onPersonSelected: (GetPeopleQuery.Person) -> Unit) {
    Column {
        Text(
            text = stringResource(R.string.people),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 24.dp,
                bottom = 24.dp
            )
        )
        HorizontalDivider(color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f))
        PersonList(onPersonSelected)
    }
}
