package comlab5exer01.example.weather.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ASUS on 2018/11/26.
 */

public class Weather {
    public String status;
    public Basic basic;
    public API aqi;
    public Now now;
    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}