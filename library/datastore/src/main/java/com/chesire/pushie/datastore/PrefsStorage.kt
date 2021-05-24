package com.chesire.pushie.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private const val STORE_NAME = "PrefsStorage"

private val Context.dataStore by preferencesDataStore(STORE_NAME)

class PrefsStorage(context: Context) {

    private val _context = context.applicationContext
    private val maxViewsKey = intPreferencesKey("pwMaxViews")

    val maxViews = _context.dataStore.data.map { pref ->
        pref[maxViewsKey] ?: 5
    }

    suspend fun setMaxViews(newMaxViews: Int) {
        _context.dataStore.edit { pref ->
            pref[maxViewsKey] = newMaxViews
        }
    }

    private fun t() {
        _context.dataStore
    }
}
