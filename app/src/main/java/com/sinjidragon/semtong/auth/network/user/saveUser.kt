package com.sinjidragon.semtong.auth.network.user

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.runBlocking

val REF_TOKEN = stringPreferencesKey("ref_token")
val ACC_TOKEN = stringPreferencesKey("acc_token")
val ROLES = stringPreferencesKey("roles")
val USER_ID = stringPreferencesKey("user_id")

fun saveRefToken(context: Context, token: String?) {
    runBlocking {
        context.dataStore.edit { preferences ->
            if (token != null) {
                preferences[REF_TOKEN] = token
            }
            else {
                preferences.remove(REF_TOKEN)
            }
        }
    }
}
fun saveAccToken(context: Context, token: String?) {
    runBlocking {
        context.dataStore.edit { preferences ->
            if (token != null) {
                preferences[ACC_TOKEN] = token
            }
            else {
                preferences.remove(ACC_TOKEN)
            }
        }
    }
}
fun saveRole(context: Context, role: String?) {
    runBlocking {
        context.dataStore.edit { preferences ->
            if (role != null) {
                preferences[ROLES] = role
            }
            else {
                preferences.remove(ROLES)
            }
        }
    }
}
fun saveUserId(context: Context, id: String?) {
    runBlocking {
        context.dataStore.edit { preferences ->
            if (id != null) {
                preferences[USER_ID] = id
            }
            else {
                preferences.remove(USER_ID)
            }
        }
    }
}