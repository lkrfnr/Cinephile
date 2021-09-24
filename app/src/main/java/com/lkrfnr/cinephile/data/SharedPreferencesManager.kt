package com.lkrfnr.cinephile.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import org.json.JSONArray
import java.util.prefs.Preferences

class SharedPreferencesManager{

    companion object{

        private var sharedPreferencesEditor:SharedPreferences.Editor? = null
        private var sharedPreferences:SharedPreferences? = null
        private const val preferencesName = "cinephile_shared_pref"

        fun init(context: Context){
            sharedPreferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
            sharedPreferencesEditor = sharedPreferences?.edit()
        }

        fun saveFirstPageResultJson(result:String){
            //Log.i("MoviePopularRepository", "In save $result")
            sharedPreferencesEditor?.putString(firstPageResultKey,result)?.apply()
        }

        fun getFirstPageResultJson() : String? {
            //Log.i("MoviePopularRepository", sharedPreferences?.getString(firstPageResultKey,"").toString())
            return sharedPreferences?.getString(firstPageResultKey,"")
        }

    }


}