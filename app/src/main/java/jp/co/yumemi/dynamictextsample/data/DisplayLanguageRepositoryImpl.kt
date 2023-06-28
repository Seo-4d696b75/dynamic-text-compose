package jp.co.yumemi.dynamictextsample.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguage
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class DisplayLanguageRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context,
) : DisplayLanguageRepository {
    private val _displayLanguage = MutableStateFlow(DisplayLanguage.English)
    override val displayLanguage = _displayLanguage.asStateFlow()

    override fun onLanguageChanged(language: DisplayLanguage) {
        TODO("Not yet implemented")
    }
}