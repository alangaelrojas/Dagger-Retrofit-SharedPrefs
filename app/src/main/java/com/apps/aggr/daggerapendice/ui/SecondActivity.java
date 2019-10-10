package com.apps.aggr.daggerapendice.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.apps.aggr.daggerapendice.BaseApplication;
import com.apps.aggr.daggerapendice.R;
import com.apps.aggr.daggerapendice.adapters.TiempoAdapter;
import com.apps.aggr.daggerapendice.api.ApiClient;
import com.apps.aggr.daggerapendice.model.Meteorologia;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button nextActivity;
    private RecyclerView rvTiempo;

    @Inject
    Context context;

    @Inject
    ApiClient apiClient;

    @Inject
    TiempoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Setup Dagger
        ((BaseApplication)getApplication()).getApplicationComponent().inject(this);

        setUpView();
        webService();
    }

    private void webService() {
        Call<Meteorologia> call = apiClient.getTiempo();
        call.enqueue(new Callback<Meteorologia>() {
            @Override
            public void onResponse(Call<Meteorologia> call, Response<Meteorologia> response) {
                   adapter.add(response.body().getList());
            }

            @Override
            public void onFailure(@NonNull Call<Meteorologia> call, @NonNull Throwable t) {
                Log.d("weather_api: ", t.getMessage());
            }
        });
    }

    private void setUpView() {
        nextActivity = findViewById(R.id.nextActivity);
        nextActivity.setOnClickListener(this);
        rvTiempo = findViewById(R.id.rvLista);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvTiempo.setLayoutManager(layoutManager);
        rvTiempo.setAdapter(adapter);
        rvTiempo.setHasFixedSize(true);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.nextActivity){
            startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
            finish();
        }
    }
}
