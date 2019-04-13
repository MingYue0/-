package comlab5exer01.example.weather.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 2018/11/26.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("cid")
    public String weatherId;

    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
