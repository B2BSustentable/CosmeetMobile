package com.example.cosmeet.domain

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cosmeet.domain.dto.BusinessResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

object UserPreferences {
    private val USER_ID = stringPreferencesKey("USER_ID")
    private val USER_NAME = stringPreferencesKey("USER_NAME")
    private val USER_EMAIL = stringPreferencesKey("USER_EMAIL")
    private val USER_PHONE = stringPreferencesKey("USER_PHONE")
    private val USER_CNPJ = stringPreferencesKey("USER_CNPJ")
    private val USER_OCCUPATION = stringPreferencesKey("USER_OCCUPATION")
    private val USER_ABOUT = stringPreferencesKey("USER_ABOUT")
    private val USER_PHOTO = stringPreferencesKey("USER_PHOTO")

    suspend fun saveUser(context: Context, businessResponse: BusinessResponse) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID] = businessResponse.id.toString()
            preferences[USER_NAME] = businessResponse.name.toString()
            preferences[USER_EMAIL] = businessResponse.email.toString()
            preferences[USER_PHONE] = businessResponse.phone.toString()
            preferences[USER_CNPJ] = businessResponse.cnpj.toString()
            preferences[USER_OCCUPATION] = businessResponse.occupation.toString()
            preferences[USER_ABOUT] = businessResponse.about.toString()
            preferences[USER_PHOTO] = businessResponse.photo.toString()
        }
    }

    fun getUser(context: Context): Flow<BusinessResponse?> {
        return context.dataStore.data.map { preferences ->
            val id = preferences[USER_ID]
            val name = preferences[USER_NAME]
            val email = preferences[USER_EMAIL]
            val phone = preferences[USER_PHONE]
            val cnpj = preferences[USER_CNPJ]
            val occupation = preferences[USER_OCCUPATION]
            val about = preferences[USER_ABOUT]
            val photo = preferences[USER_PHOTO]

            if (id != null && name != null && email != null && phone != null && cnpj != null && occupation != null && about != null && photo != null) {
                BusinessResponse(
                    id = id.toLong(),
                    name = name,
                    email = email,
                    phone = phone,
                    cnpj = cnpj,
                    occupation = occupation,
                    about = about,
                    photo = photo,
                    address = null
                )
            } else {
                null
            }
        }
    }
}
