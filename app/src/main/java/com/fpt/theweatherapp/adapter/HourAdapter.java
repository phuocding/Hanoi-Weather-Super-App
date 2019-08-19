package com.fpt.theweatherapp.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpt.theweatherapp.R;
import com.fpt.theweatherapp.model.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Weather> listWeather;

    public HourAdapter(Activity activity, List<Weather> listWeather) {
        this.activity = activity;
        this.listWeather = listWeather;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_hour, viewGroup, false);
        HourHolder hourHolder = new HourHolder(view);
        return hourHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HourHolder hourHolder = (HourHolder) viewHolder;
        Weather weather = listWeather.get(i);
        hourHolder.tvTime.setText(convertTime(weather.getDateTime()));
        hourHolder.tvTemp.setText(weather.getTemperature().getValue()+"°c");

        String url = "";
        if (weather.getWeatherIcon() < 10) {
            url = "https://developer.accuweather.com/sites/default/files/0" + weather.getWeatherIcon() + "-s.png";
        } else {
            url = "https://developer.accuweather.com/sites/default/files/" + weather.getWeatherIcon() + "-s.png";
        }
        Glide.with(activity).load(url).into(hourHolder.iconStatus);
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    public static class HourHolder extends RecyclerView.ViewHolder{
        private TextView tvTime;
        private ImageView iconStatus;
        private TextView tvTemp;

        public HourHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            iconStatus = itemView.findViewById(R.id.iconStatus);
            tvTemp = itemView.findViewById(R.id.tvTemp);
        }
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
