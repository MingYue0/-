package comlab5exer01.example.weather.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 2018/11/26.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}

