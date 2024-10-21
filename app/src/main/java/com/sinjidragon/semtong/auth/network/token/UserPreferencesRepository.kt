package com.sinjidragon.semtong.auth.network.token

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "token")