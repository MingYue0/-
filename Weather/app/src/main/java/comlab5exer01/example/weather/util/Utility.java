package comlab5exer01.example.weather.util;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import comlab5exer01.example.weather.json.Weather;

/**
 * Created by ASUS on 2018/11/26.
 */
public class Utility {
    public static Weather handleWeatherResponce(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
