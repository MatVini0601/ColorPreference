package com.example.colorpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private final SharedPreferences mPreferences;

    public Preference(Context context){
        this.mPreferences = context.getSharedPreferences("colors",context.MODE_PRIVATE);
    }

    public void storeColor(String key, String color){
        this.mPreferences.edit().putString(key,color).apply();
    }

    public String getStoredValue(String key){
       return this.mPreferences.getString(key,"null");
    }
}
