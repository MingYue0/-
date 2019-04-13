package comlab5exer01.example.weather.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 2018/11/26.
 */

public class API {
    public APICity city;

    public class APICity {
        public String aqi;
        public String pm25;
    }
}
