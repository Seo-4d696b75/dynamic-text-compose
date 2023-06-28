package jp.co.yumemi.dynamictextsample.domain

sealed interface TextCatalog {
    object Initializing : TextCatalog
    data class Data(
        val language: DisplayLanguage,
        val data: Map<TextId, String>,
    ) : TextCatalog
}