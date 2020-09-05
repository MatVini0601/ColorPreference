package com.example.colorpreference;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private Preference preference;
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.bar = getSupportActionBar();
        this.mViewHolder.view = findViewById(R.id.colorView);
        this.preference = new Preference(this);

        if (preference.getStoredValue("theme") == "null"){
            this.mViewHolder.view.setBackgroundColor(Color.parseColor("#ffffff"));
        }else{
            this.mViewHolder.view.setBackgroundColor(Color.parseColor(preference.getStoredValue("theme")));
            this.mViewHolder.bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(preference.getStoredValue("themebar"))));
            getWindow().setStatusBarColor(Color.parseColor(preference.getStoredValue("themestatus")));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.cor1:
                preference.storeColor("theme","#FA7C52");
                preference.storeColor("themebar", "#FF5C29");
                preference.storeColor("themestatus", "#C94A21");
                setTheme();
                break;
            case R.id.cor2:
                preference.storeColor("theme","#60DF65");
                preference.storeColor("themebar", "#22AD27");
                preference.storeColor("themestatus", "#2E6B31");
                setTheme();
                break;
            case R.id.vintage:
                preference.storeColor("theme", "#8F1383");
                preference.storeColor("themebar", "#45056E");
                preference.storeColor("themestatus", "#1F024C");
                setTheme();
                break;
            case R.id.dark:
                preference.storeColor("theme", "#525252");
                preference.storeColor("themebar", "#414141");
                preference.storeColor("themestatus", "#313131");
                setTheme();
        }
        return true;
    }

    public void setTheme(){
        this.mViewHolder.view.setBackgroundColor(Color.parseColor(preference.getStoredValue("theme")));
        this.mViewHolder.bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(preference.getStoredValue("themebar"))));
        getWindow().setStatusBarColor(Color.parseColor(preference.getStoredValue("themestatus")));
    }

    private static class ViewHolder{
        private ActionBar bar;
        private View view;
    }
}
