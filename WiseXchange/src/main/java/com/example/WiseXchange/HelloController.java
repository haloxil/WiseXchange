package com.example.WiseXchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.*;

@RestController
public class HelloController {

    @GetMapping("/index")
    public String index() {
        try {
            URL url = new URL(
                    "https://www.dbs.com/sandbox/api/sg/v1/rates/historicalExchangeRates?quoteCurrency=USD&fromDate=2027-08-31&toDate=2027-08-31&boardRateType=On%20Demand");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("clientId", "clientId1");
            conn.setRequestProperty("accessToken",
                    "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiIDogImNhcGkuZGJzLmNvbSIsInB0eXR5cGUiIDogIjMiLCJjbG50eXBlIiA6ICIyIiwiY2xuaWQiIDogImNsaWVudElkMSIsIlBhcnR5SWQiIDogIlltRmllUT09IiwgImFjY2VzcyIgOiAiMUZBIiwic2NvcGUiIDogIlJFQUQiICwiYXVkIiA6ICJjYXBpLmRicy5jb20vYWNjZXNzIiAsImlhdCIgOiAiVHVlIEF1ZyAwOCAxNDo0MDo1NyBTR1QgMjAxNyIsICJleHAiIDogIjE1MDIxODUyNTc5ODYifQ.cWTXScPzTJXyHZdMVJ_OvffDJBUJHqlfRq-6khf70cE");
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode() + " "
                        + conn.getErrorStream() + " " + conn.getResponseMessage());
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));) {
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Unable to call API." + e.getMessage());
        }

        return "Hello";
    }

    @GetMapping("/login")
    public String login() {
        return "Greetings from Spring Boot Login Page!";
    }

}
