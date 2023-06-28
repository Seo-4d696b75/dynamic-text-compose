package jp.co.yumemi.dynamictextsample.domain

enum class DisplayLanguage(
    val textId: TextId
) {
    English(TextId.language_english),
    Japanese(TextId.language_japanese),
    French(TextId.language_french),
    Thai(TextId.language_thai),
}