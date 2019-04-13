package comlab5exer01.example.weather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ASUS on 2018/11/26.
 */
public class HttpUilt {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
