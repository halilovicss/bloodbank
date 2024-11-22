package com.online.template.core.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import java.util.concurrent.ConcurrentHashMap

object SharedPrefsStorage {
    private val sharedPrefsMap: ConcurrentHashMap<String, SharedPreferences> =
        ConcurrentHashMap<String, SharedPreferences>()

    fun initSharedPrefs(context: Context) {
        //     PlainPrefs.entries.forEach { key ->
        //            addSharedPrefsToMap(context, key.key)
        //        }
    }

    fun findSharedPrefs(sharePrefsName: String): SharedPreferences? {
        return sharedPrefsMap[sharePrefsName]
    }

    fun clearSharedPrefs() {
        // clear all prefs except settings
        sharedPrefsMap.clear()
    }

    private fun addSharedPrefsToMap(context: Context, sharedPrefsKey: String) {
        val sharedPrefs = context.getSharedPreferences(sharedPrefsKey, Context.MODE_PRIVATE)
        sharedPrefs.edit().apply()
        sharedPrefsMap[sharedPrefsKey] = sharedPrefs
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    fun setValue(prefsName: String, key: String, value: Any?) {
        val prefs = findSharedPrefs(prefsName) ?: return
        when (value) {
            is String? -> prefs.edit { it.putString(key, value) }
            is Int -> prefs.edit { it.putInt(key, value) }
            is Boolean -> prefs.edit { it.putBoolean(key, value) }
            is Float -> prefs.edit { it.putFloat(key, value) }
            is Long -> prefs.edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Type not supported")
        }
    }

    inline fun <reified T : Any> getValue(
        prefsName: String,
        key: String,
        defaultValue: T? = null
    ): T? {
        val prefs = findSharedPrefs(prefsName) ?: return null
        return when (T::class) {
            String::class -> prefs.getString(key, defaultValue as? String) as T?
            Int::class -> prefs.getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> prefs.getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> prefs.getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> prefs.getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Type not supported")
        }
    }
}
