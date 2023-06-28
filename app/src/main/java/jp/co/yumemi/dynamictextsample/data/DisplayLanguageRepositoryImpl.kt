package jp.co.yumemi.dynamictextsample.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguage
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguageRepository
import jp.co.yumemi.dynamictextsample.domain.TextId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class DisplayLanguageRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : DisplayLanguageRepository {
    private val _provider = MutableStateFlow(
        TextProviderImpl(
            language = DisplayLanguage.English,
            data = emptyMap(),
        )
    )
    override val provider = _provider.asStateFlow()

    @OptIn(ExperimentalSerializationApi::class)
    override fun onLanguageChanged(language: DisplayLanguage) {
        val fileName = "text_${language.name.lowercase()}.json"
        val serializer = MapSerializer(String.serializer(), String.serializer())
        val map = context
            .assets
            .open(fileName)
            .use {
                Json.decodeFromStream(serializer, it)
            }
            .entries
            .associate { entry ->
                val id = TextId.values().first { it.name == entry.key }
                id to entry.value
            }
        _provider.update {
            TextProviderImpl(
                language = language,
                data = map,
            )
        }
    }
}