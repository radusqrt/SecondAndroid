package com.devacademy.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by radus on 12/7/2015.
 */
public class WeatherAdapter extends ArrayAdapter<Weather> {

    Context context;
    int layoutResourceId;
    Weather data[] = null;

    public WeatherAdapter(Context context, int layoutResourceId, Weather[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new WeatherHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.emoticonIcon = (ImageView)row.findViewById(R.id.imgIcon1);
            holder.roadIcon = (ImageView)row.findViewById(R.id.imgIcon2);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.date = (TextView)row.findViewById(R.id.date);
            holder.pace = (TextView)row.findViewById(R.id.pace);
            holder.totalTime = (TextView)row.findViewById(R.id.totalTime);


            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }

        Weather weather = data[position];
        holder.txtTitle.setText(weather.title);
        holder.imgIcon.setImageResource(weather.icon);
        holder.emoticonIcon.setImageResource(weather.emoticon);
        holder.roadIcon.setImageResource(weather.roadImg);
        holder.date.setText(weather.date.toString().substring(4, 10) + weather.date.toString().substring(23, 28));
        holder.pace.setText(weather.pace);
        holder.totalTime.setText(weather.totalTime);

        return row;
    }

    static class WeatherHolder
    {
        ImageView imgIcon;
        ImageView emoticonIcon;
        ImageView roadIcon;
        TextView txtTitle;
        TextView date;
        TextView pace;
        TextView totalTime;
    }
}

