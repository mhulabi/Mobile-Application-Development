package com.example.smsgateway;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.telephony.SmsManager;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMS extends AsyncTask<String, Integer, Integer> {
    String input = "", message, phoneNumber;
    private TextView textview;
    int id, counter = 0;
    JSONArray json;
    JSONObject json1;
    public boolean flag = false;

    public SMS(TextView t, int smss){
        this.textview = t;
        this.counter = smss;
    }

    @Override
    protected Integer doInBackground(String... params) {

        try{
            URL url2 = new URL("http://10.91.1.127:3000/getSMS/");
        while(flag == true){
            HttpURLConnection urlC2 = (HttpURLConnection) url2.openConnection();
            urlC2.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlC2.getInputStream()));
        input = reader.readLine();
        json = new JSONArray(input);
        json1 = json.getJSONObject(0);
        message = json1.getString("message");
        id = json1.getInt("id");
        String idd = "id=" + Integer.toString(id);
        phoneNumber = json1.getString("phonenumber");
        urlC2.disconnect();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("5556",
                    null,
                    "message",
                    null,
                    null);
        SS(idd);
        counter++;
        publishProgress(counter);
            SystemClock.sleep(5000);}
    }
        catch (Exception e) {
            e.printStackTrace();}

        return 0;
    }

    @Override
    protected void onProgressUpdate(Integer... args) {
        super.onProgressUpdate(args);
        textview.setText("Sent SMS Messages: " + counter);
    }

    public void SS(String id){

        try{URL url3 = new URL("http://10.91.1.127:3000/smsSent/");
            HttpURLConnection urlC3 = (HttpURLConnection) url3.openConnection();
            urlC3.setRequestMethod("POST");
            urlC3.setDoOutput(true);
            OutputStream out = new BufferedOutputStream(urlC3.getOutputStream());
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(out, "UTF-8"));
            writer.write(id);
            writer.flush();
            writer.close();
            int respo = urlC3.getResponseCode();
        }
        catch (Exception e) {
            e.printStackTrace();}
    }

    public int getI(){
        return counter;
    }

}

