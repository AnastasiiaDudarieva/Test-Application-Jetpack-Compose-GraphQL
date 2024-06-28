package com.testapplication.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.testapplication.app.GetPeopleQuery
import com.testapplication.app.R

@Composable
fun PersonItem(person: GetPeopleQuery.Person, onPersonSelected: (GetPeopleQuery.Person) -> Unit) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .clickable { onPersonSelected(person) }
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = person.name ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = context.getString(R.string.height, person.height),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = context.getString(R.string.mass, person.mass),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(R.drawable.chevron_right),
            contentDescription = "Person info"
        )
    }
}
