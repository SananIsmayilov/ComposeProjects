package codeisgroup.sananismayilov.onboarding.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideSp(@ApplicationContext context: Context): SharedPreferences {
        val sp: SharedPreferences = context.getSharedPreferences(
            "composeApp", Context.MODE_PRIVATE
        )

        return sp
    }

    @Singleton
    @Provides
    fun provideSpeditor(sp: SharedPreferences): SharedPreferences.Editor {
        return sp.edit()
    }


}