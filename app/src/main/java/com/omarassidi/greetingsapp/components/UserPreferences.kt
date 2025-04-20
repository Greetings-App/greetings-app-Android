package com.omarassidi.greetingsapp.components

import android.app.LocaleManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.preference.PreferenceManager


class UserPreferences(private val context: Context) {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    fun setLocale(locale: String) {
        updateResources(locale)
        preferences.edit().putString("LOCALE", locale).apply()
    }

    private fun getLocale(): String {
        return preferences.getString("LOCALE", null) ?: "en"
    }

    fun loadResources() {
        updateResources(getLocale())
    }

    fun updateResources(language: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.getSystemService(LocaleManager::class.java).applicationLocales =
                LocaleList.forLanguageTags(language)
        } else {
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(language))
        }
    }

}