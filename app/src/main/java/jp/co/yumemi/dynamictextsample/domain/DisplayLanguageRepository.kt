package jp.co.yumemi.dynamictextsample.domain

import kotlinx.coroutines.flow.StateFlow

interface DisplayLanguageRepository {
    val provider: StateFlow<TextProvider>
    fun onLanguageChanged(language: DisplayLanguage)
}