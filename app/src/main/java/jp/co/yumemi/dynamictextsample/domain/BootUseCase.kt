package jp.co.yumemi.dynamictextsample.domain

import kotlinx.coroutines.delay
import javax.inject.Inject

class BootUseCase @Inject constructor(
    private val displayLanguageRepository: DisplayLanguageRepository,
) {
    suspend operator fun invoke() {
        delay(2000L)
        displayLanguageRepository.onLanguageChanged(DisplayLanguage.English)
    }
}