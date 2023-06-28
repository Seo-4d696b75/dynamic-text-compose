package jp.co.yumemi.dynamictextsample.domain

data class TextCatalog(
    val language: DisplayLanguage,
    val data: Map<TextId, String>,
) {
    companion object {
        val Empty = TextCatalog(
            language = DisplayLanguage.English,
            data = emptyMap(),
        )
    }
}