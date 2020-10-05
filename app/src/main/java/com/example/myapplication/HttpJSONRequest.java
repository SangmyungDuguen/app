package com.example.myapplication;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpJSONRequest extends AsyncTask<String, Void, Void> {

    private String strUrl;
    private JSONObject jsonParam;


    public HttpJSONRequest(String strUrl, JSONObject jsonParam) {
        this.strUrl = strUrl;
        this.jsonParam = jsonParam;
    }

    @Override
    protected Void doInBackground(String... params) {
        JSONObject jsonResponse = new JSONObject();
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("content-type", "application/json");
            conn.setRequestProperty("accept", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            os.write(jsonParam.toString().getBytes("utf-8"));
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            String page="";
            while((line = br.readLine()) != null){
                page+=line;
            }
            jsonResponse = new JSONObject(page);


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
