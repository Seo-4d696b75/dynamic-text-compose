package jp.co.yumemi.dynamictextsample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguageRepository
import jp.co.yumemi.dynamictextsample.domain.TextCatalog
import jp.co.yumemi.dynamictextsample.domain.TextId

val LocalTextCatalog = compositionLocalOf<TextCatalog>(
    policy = neverEqualPolicy(),
) {
    TextCatalog.Initializing
}

@Composable
fun rememberTextCatalog(): State<TextCatalog> {
    return if (LocalInspectionMode.current) {
        rememberUpdatedState(newValue = TextCatalog.Initializing)
    } else {
        val context = LocalContext.current.applicationContext
        val entry = remember(context) {
            EntryPoints.get(context, ThemeEntryPoint::class.java)
        }
        entry.displayLanguageRepository.catalog.collectAsStateWithLifecycle(
            minActiveState = Lifecycle.State.RESUMED,
        )
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
        when (val catalog = LocalTextCatalog.current) {
            TextCatalog.Initializing -> throw IllegalStateException("not initialized yet")
            is TextCatalog.Data -> catalog.data[id]
                ?: throw IllegalArgumentException("string not found. id: $id")
        }
    }
}