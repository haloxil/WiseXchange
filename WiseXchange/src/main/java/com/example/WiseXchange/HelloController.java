package com.example.WiseXchange;

import com.example.WiseXchange.models.ExchangeForm;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class HelloController {
    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("exchangeForm", new ExchangeForm());
        return "form";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute ExchangeForm exchangeForm, Model model) throws IOException, JSONException{
        model.addAttribute("exchangeForm", exchangeForm);
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=" + exchangeForm.getTo() +
                        "&from=" + exchangeForm.getFrom() + "&amount=" + exchangeForm.getAmount())
                .addHeader("apikey", "HSjaNL3rJldGusO7sMstFOJh3tQRdOmL")
                .get().build();

        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        JSONObject Jobject = new JSONObject(jsonData);
        String date = Jobject.getString("date");
        model.addAttribute("date", date);
        Double rate = Jobject.getJSONObject("info").getDouble("rate");
        model.addAttribute("rate", rate);
        Double result = Jobject.getDouble("result");
        model.addAttribute("result", result);
        return "result";
    }

}
