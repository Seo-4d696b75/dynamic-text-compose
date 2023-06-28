package jp.co.yumemi.dynamictextsample.data

import jp.co.yumemi.dynamictextsample.domain.DisplayLanguage
import jp.co.yumemi.dynamictextsample.domain.TextId
import jp.co.yumemi.dynamictextsample.domain.TextProvider

class TextProviderImpl(
    override val language: DisplayLanguage,
    private val data: Map<TextId, String>,
) : TextProvider {
    override fun getString(id: TextId): String {
        return data[id] ?: throw IllegalArgumentException("string not found. id: $id")
    }
}