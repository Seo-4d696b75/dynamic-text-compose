package jp.co.yumemi.dynamictextsample.domain

interface TextProvider {
    val language: DisplayLanguage
    fun getString(id: TextId): String
}