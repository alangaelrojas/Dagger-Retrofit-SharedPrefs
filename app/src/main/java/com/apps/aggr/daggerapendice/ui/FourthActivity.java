package com.apps.aggr.daggerapendice.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.apps.aggr.daggerapendice.BaseApplication;
import com.apps.aggr.daggerapendice.R;
import com.apps.aggr.daggerapendice.constants.Constants;

import javax.inject.Inject;

public class FourthActivity extends AppCompatActivity {

    private TextView temp, humi;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        ((BaseApplication)getApplication()).plusSharedPreferencesSubComponent().inject(this);

        setUpView();
    }

    private void setUpView() {

        temp = findViewById(R.id.tvTemperatura);
        humi = findViewById(R.id.tvHumedad);
        temp.setText(sharedPreferences.getString(Constants.temperatura, "0"));
        humi.setText(sharedPreferences.getString(Constants.humedad, "0"));
    }
}
