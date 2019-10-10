package com.apps.aggr.daggerapendice.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.apps.aggr.daggerapendice.BaseApplication;
import com.apps.aggr.daggerapendice.R;
import com.apps.aggr.daggerapendice.model.Mensaje;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitle, tvDescripcion;

    @Inject
    Mensaje mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication)getApplication()).getMensajeComponent().inject(this);


        setUpView();
    }


    private void setUpView() {
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(mensaje.getMensajeTitle());
        tvDescripcion = findViewById(R.id.tvDescription);
        tvDescripcion.setText(mensaje.getMensajeDescription());
        tvDescripcion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tvDescription){
            startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BaseApplication)getApplication()).clearMensajeComponent();
    }
}
