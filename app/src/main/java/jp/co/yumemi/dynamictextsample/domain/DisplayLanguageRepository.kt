package jp.co.yumemi.dynamictextsample.domain

import kotlinx.coroutines.flow.StateFlow

interface DisplayLanguageRepository {
    val catalog: StateFlow<TextCatalog>
    fun onLanguageChanged(language: DisplayLanguage)
}