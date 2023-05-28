package com.example.android.dagger.di

import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module

// Сообщает Dagger, что это модуль Dagger.
@Module
abstract class StorageModule {
    @Binds // анатация показывает какую реализацию интерфейса внедрить при необходимости
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage // Реализация указывается путем добавления параметра с типом реализации интерфейса (т.е. SharedPreferencesStorage).
}