package jp.co.yumemi.dynamictextsample.ui.section.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> Spinner(
    selectedItem: T,
    items: List<T>,
    itemLabel: (T) -> String,
    onItemSelected: (T) -> Unit,
    modifier: Modifier = Modifier,
) {

    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier.wrapContentHeight(),
    ) {
        OutlinedCard(
            onClick = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = itemLabel(selectedItem),
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp,
                        ),
                )
                Icon(
                    Icons.Outlined.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
        ) {
            items.forEach {
                DropdownMenuItem(
                    text = { Text(itemLabel(it)) },
                    onClick = {
                        onItemSelected(it)
                        expanded = false
                    },
                )
            }
        }
    }
}