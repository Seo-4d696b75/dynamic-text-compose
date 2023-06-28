package jp.co.yumemi.dynamictextsample.domain

import kotlinx.coroutines.flow.StateFlow

interface DisplayLanguageRepository {
    val displayLanguage: StateFlow<DisplayLanguage>
    fun onLanguageChanged(language: DisplayLanguage)
}