package com.example.android.dagger.di

import android.app.Activity
import android.content.Context
import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import com.example.android.dagger.settings.SettingsActivity
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton // Теперь классы с аннотацией @Singleton будут ограничены AppComponent
@Component(modules = [StorageModule::class, AppSubcomponents::class]) // указываем какие модули использовать
interface AppComponent {

    // Фабрика для создания экземпляров AppComponent
    @Component.Factory
    interface Factory {
        // нам нужен context для SharedPreferencesStorage
        fun create(@BindsInstance context: Context): AppComponent
    }
    // Классы, которые могут быть внедрены этим компонентом
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    fun userManager(): UserManager
}

