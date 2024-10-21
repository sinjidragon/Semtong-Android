package com.sinjidragon.semtong.auth.network.token

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.runBlocking

val REF_TOKEN = stringPreferencesKey("auth_token")
val ACC_TOKEN = stringPreferencesKey("auth_token")

fun saveRefToken(context: Context, token: String) {
    runBlocking {
        context.dataStore.edit { preferences ->
            preferences[REF_TOKEN] = token
        }
    }
}
fun saveAccToken(context: Context, token: String) {
    runBlocking {
        context.dataStore.edit { preferences ->
            preferences[ACC_TOKEN] = token
        }
    }
}