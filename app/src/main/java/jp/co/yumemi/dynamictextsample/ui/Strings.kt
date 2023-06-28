package jp.co.yumemi.dynamictextsample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguageRepository
import jp.co.yumemi.dynamictextsample.domain.TextCatalog
import jp.co.yumemi.dynamictextsample.domain.TextId

val LocalTextCatalog = staticCompositionLocalOf<TextCatalog> {
    TextCatalog.Empty
}

@Composable
fun rememberTextCatalog(): State<TextCatalog> {
    return if (LocalInspectionMode.current) {
        rememberUpdatedState(newValue = TextCatalog.Empty)
    } else {
        val context = LocalContext.current.applicationContext
        val entry = remember(context) {
            EntryPoints.get(context, ThemeEntryPoint::class.java)
        }
        entry.displayLanguageRepository.catalog.collectAsState()
    }
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ThemeEntryPoint {
    val displayLanguageRepository: DisplayLanguageRepository
}

@Composable
fun stringResource(id: TextId): String {
    return if (LocalInspectionMode.current) {
        androidx.compose.ui.res.stringResource(id = id.xmlId)
    } else {
        val catalog = LocalTextCatalog.current
        catalog.data[id] ?: throw IllegalArgumentException("string not found. id: $id")
    }
}