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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguage
import jp.co.yumemi.dynamictextsample.domain.TextId
import jp.co.yumemi.dynamictextsample.ui.stringResource
import jp.co.yumemi.dynamictextsample.ui.theme.DynamicTextSampleTheme

@Composable
fun SettingSection(
    viewModel: SettingViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SettingSection(
        selectedLanguage = uiState.selectedLanguage,
        languageList = uiState.languageList,
        onLanguageSelected = viewModel::onLanguageSelected,
        isChangeLanguageEnabled = uiState.isChangeEnabled,
        onLanguageChanged = viewModel::onDisplayLanguageChanged,
        modifier = modifier,
    )
}

@Composable
fun SettingSection(
    selectedLanguage: DisplayLanguage,
    languageList: List<DisplayLanguage>,
    onLanguageSelected: (DisplayLanguage) -> Unit,
    isChangeLanguageEnabled: Boolean,
    onLanguageChanged: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(id = TextId.setting_title))
        Spinner(
            selectedItem = selectedLanguage,
            items = languageList,
            itemLabel = { stringResource(id = it.textId) },
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
                onClick = onLanguageChanged,
                enabled = isChangeLanguageEnabled,
            ) {
                Text(text = stringResource(id = TextId.setting_button))
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingSection() {
    DynamicTextSampleTheme {
        SettingSection(
            selectedLanguage = DisplayLanguage.English,
            languageList = DisplayLanguage.values().toList(),
            isChangeLanguageEnabled = true,
            onLanguageChanged = {},
            onLanguageSelected = {},
        )
    }
}
