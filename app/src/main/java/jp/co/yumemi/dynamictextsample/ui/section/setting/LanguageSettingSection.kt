package jp.co.yumemi.dynamictextsample.ui.section.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguage
import jp.co.yumemi.dynamictextsample.ui.theme.DynamicTextSampleTheme

@Composable
fun SettingSection(
    currentLanguage: DisplayLanguage,
    languageList: List<DisplayLanguage>,
    onLanguageSelected: (DisplayLanguage) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "select display language")
        Spinner(
            selectedItem = currentLanguage,
            items = languageList,
            itemLabel = { it.name },
            onItemSelected = onLanguageSelected,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedButton(
                onClick = {},
                enabled = false,
            ) {
                Text(text = "Change")
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingSection() {
    DynamicTextSampleTheme {
        SettingSection(
            currentLanguage = DisplayLanguage.English,
            languageList = DisplayLanguage.values().toList(),
            onLanguageSelected = {},
        )
    }
}
