package jp.co.yumemi.dynamictextsample.ui.section.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguage
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguageRepository
import jp.co.yumemi.dynamictextsample.domain.TextCatalog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val displayLanguageRepository: DisplayLanguageRepository,
) : ViewModel() {

    private val selectedLanguage = MutableStateFlow(DisplayLanguage.English)

    val uiState: StateFlow<SettingUiState> = combine(
        displayLanguageRepository.catalog,
        selectedLanguage,
    ) { catalog, selected ->
        SettingUiState(
            selectedLanguage = selected,
            languageList = DisplayLanguage.values().toList(),
            isChangeEnabled = !catalog.equalsLanguage(selected),
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        SettingUiState.initialState,
    )

    fun onLanguageSelected(language: DisplayLanguage) {
        selectedLanguage.update { language }
    }

    fun onDisplayLanguageChanged() {
        val selected = selectedLanguage.value
        displayLanguageRepository.onLanguageChanged(selected)
    }

    private fun TextCatalog.equalsLanguage(language: DisplayLanguage): Boolean {
        return when (this) {
            TextCatalog.Initializing -> false
            is TextCatalog.Data -> this.language == language
        }
    }
}