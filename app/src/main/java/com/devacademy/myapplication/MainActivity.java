package com.devacademy.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MainActivity extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Weather weather_data[] = new Weather[0];
        try {
            weather_data = new Weather[] {
                            new Weather(R.drawable.weather_cloudy, R.drawable.evil, R.drawable.road, "7.72", fmt.parse("2015-05-06"), "8'58''", "1:09:08"),
                            new Weather(R.drawable.weather_showers, R.drawable.wink, R.drawable.road, "6.34", fmt.parse("2015-08-15"), "6'56''", "43:57"),
                            new Weather(R.drawable.weather_snow, R.drawable.smile, R.drawable.road2, "11.81", fmt.parse("2015-09-24"), "6'34''", "1:17:36"),
                            new Weather(R.drawable.weather_storm, R.drawable.smile, R.drawable.road3, "5.90", fmt.parse("2015-12-12"), "6'12''", "36:36"),
                            new Weather(R.drawable.weather_showers, R.drawable.wink, R.drawable.road, "6.34", fmt.parse("2015-11-22"), "6'56''", "43:57"),
                            new Weather(R.drawable.weather_snow, R.drawable.smile, R.drawable.road2, "11.81", fmt.parse("2015-01-06"), "6'34''", "1:17:36"),
                            new Weather(R.drawable.weather_storm, R.drawable.smile, R.drawable.road3, "5.90", fmt.parse("2015-01-08"), "6'12''", "36:36"),
                            new Weather(R.drawable.weather_showers, R.drawable.wink, R.drawable.road, "6.34", fmt.parse("2015-03-11"), "6'56''", "43:57"),
                            new Weather(R.drawable.weather_snow, R.drawable.smile, R.drawable.road2, "11.81", fmt.parse("2015-04-30"), "6'34''", "1:17:36"),
                            new Weather(R.drawable.weather_storm, R.drawable.smile, R.drawable.road3, "5.90", fmt.parse("2015-09-29"), "6'12''", "36:36"),
                            new Weather(R.drawable.weather_sunny, R.drawable.wink, R.drawable.road2, "12.01", fmt.parse("2015-08-01"), "5'77", "1:20:19")
                    };
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Collections.sort(Arrays.asList(weather_data), new Comparator<Weather>() {
            public int compare(Weather o1, Weather o2) {
                return o2.getDateTime().compareTo(o1.getDateTime());
            }
        });

        WeatherAdapter adapter = new WeatherAdapter(this,
                R.layout.listview_item_row, weather_data);


        listView1 = (ListView) findViewById(R.id.listView1);

        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView1.addHeaderView(header);

        listView1.setAdapter(adapter);
    }
}