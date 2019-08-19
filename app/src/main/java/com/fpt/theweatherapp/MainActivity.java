package com.fpt.theweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.fpt.theweatherapp.adapter.HourAdapter;
import com.fpt.theweatherapp.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTemp;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTemp = findViewById(R.id.tvTemp);
        tvStatus = findViewById(R.id.tvStatus);

        getHours();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvHour = findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);
    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiManager.API_URL).addConverterFactory(GsonConverterFactory.create()).build();

        ApiManager apiManager = retrofit.create(ApiManager.class);

        apiManager.getHour().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {

                if (response.body() == null) return;

                List<Weather> listWeather = response.body();
                HourAdapter hourAdapter = new HourAdapter(MainActivity.this,listWeather);
                rvHour.setAdapter(hourAdapter);

                Weather weather = listWeather.get(0);
                tvTemp.setText(weather.getTemperature().getValue()+ "°c");
                tvStatus.setText(weather.getIconPhrase());
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {

            }
        });
    }
}
