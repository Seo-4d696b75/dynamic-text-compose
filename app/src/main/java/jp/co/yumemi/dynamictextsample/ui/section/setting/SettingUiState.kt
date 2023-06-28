package jp.co.yumemi.dynamictextsample.ui.section.setting

import androidx.compose.runtime.Stable
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguage

@Stable
data class SettingUiState(
   val selectedLanguage: DisplayLanguage,
   val languageList: List<DisplayLanguage>,
   val isChangeEnabled: Boolean,
) {
    companion object {
        val initialState = SettingUiState(
            selectedLanguage = DisplayLanguage.English,
            languageList = emptyList(),
            isChangeEnabled = false,
        )
    }
}
