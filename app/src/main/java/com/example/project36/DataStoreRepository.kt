package com.example.project36

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import java.io.IOException
import javax.inject.Inject


private  const val  PREFERENCES_NAME="images_preferences"



val Context.datastore : DataStore<Preferences> by  preferencesDataStore(name = PREFERENCES_NAME)


class DataStoreRepository @Inject constructor(private val context: Application)  {

    companion object{
        val FIREBASE_USER_KEY = stringPreferencesKey("key")
        val FIREBASE_USER_TEXT = stringPreferencesKey("text")

    }

    suspend fun saveKey(key: String,text:String) {
        context.datastore.edit {
           it[FIREBASE_USER_KEY] =key
           it[FIREBASE_USER_TEXT] =text


        }

    }

    val readKey: Flow<String> = context.datastore.data
        .catch { exception ->
            if (exception is IOException) {

                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map {
            val key = it[FIREBASE_USER_KEY] ?:""

           key
        }
}




