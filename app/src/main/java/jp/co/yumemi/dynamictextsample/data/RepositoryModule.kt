package jp.co.yumemi.dynamictextsample.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.dynamictextsample.domain.DisplayLanguageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindDisplayLanguageManager(impl: DisplayLanguageRepositoryImpl): DisplayLanguageRepository
}