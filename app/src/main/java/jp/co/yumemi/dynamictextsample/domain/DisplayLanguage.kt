package jp.co.yumemi.dynamictextsample.domain

enum class DisplayLanguage(
    val code: String,
    val textId: TextId
) {
    English("en", TextId.language_english),
    Japanese("ja", TextId.language_japanese),
    French("fr", TextId.language_french),
    Thai("th", TextId.language_thai),
}