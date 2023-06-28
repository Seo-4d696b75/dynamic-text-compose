package jp.co.yumemi.dynamictextsample.domain

import androidx.annotation.StringRes
import jp.co.yumemi.dynamictextsample.R

@Suppress("EnumEntryName")
enum class TextId(
   @StringRes val xmlId: Int
) {
    app_bar_title(R.string.app_bar_title),
    home_title(R.string.home_title),
    home_body(R.string.home_body),
    setting_title(R.string.setting_title),
    setting_button(R.string.setting_button),
    language_english(R.string.language_english),
    language_japanese(R.string.language_japanese),
    language_french(R.string.language_french),
    language_thai(R.string.language_thai),
}