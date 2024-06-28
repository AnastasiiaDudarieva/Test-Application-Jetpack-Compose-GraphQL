package com.testapplication.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.testapplication.app.GetPersonQuery

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailSheet(
    person: GetPersonQuery.Person,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        dragHandle = null,
        content = {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "${person.name}",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Homeworld: ${person.homeworld?.name}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Height: ${person.height}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Hair Color: ${person.hairColor}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Gender: ${person.gender}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Eye Color: ${person.eyeColor}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Skin Color: ${person.skinColor}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Mass: ${person.mass}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    )
}
