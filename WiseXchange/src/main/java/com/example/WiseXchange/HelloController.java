package com.example.WiseXchange;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/index")
    public String index() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=SGD&from=EUR&amount=5")
                .addHeader("apikey", "HSjaNL3rJldGusO7sMstFOJh3tQRdOmL")
                .get().build();

    Response response = client.newCall(request).execute();
    String jsonData = response.body().string();
    JSONObject Jobject = new JSONObject(jsonData);
    String Date = Jobject.getString("date");
    Double rate = Jobject.getJSONObject("info").getDouble("rate");
    Double result = Jobject.getDouble("result");

    return Date + ": Converting 5 EUR to SGD has a rate of " + rate + " which gives you " + result;
}

    @GetMapping("/login")
    public String login() {
        return "Greetings from Spring Boot Login Page!";
    }

}
