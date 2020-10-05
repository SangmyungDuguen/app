package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity  {

    private String strUrl;
    private JSONObject jsonParam;

    String TextInputEditText_signupEmail;
    String TextInputEditText_signupPassword;
    String TextInputEditText_name;
    private Button btn_signUp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViewById(R.id.btn_signUp2).setOnClickListener(buttonClick);

    }

    Button.OnClickListener buttonClick = new Button.OnClickListener() {
        public void onClick(View v) {
            TextInputEditText_signupEmail = ((EditText)(findViewById(R.id.TextInputEditText_signupEmail))).getText().toString();
//            TextInputEditText_signupPassword = ((EditText)(findViewById(R.id.TextInputEditText_signupPassword))).getText().toString();
            TextInputEditText_name = ((EditText)(findViewById(R.id.TextInputEditText_name))).getText().toString();

            String url = "http://e91ecf039e93.ngrok.io/api/user/save";
            JSONObject jsonParam = new JSONObject();
            try {
                jsonParam.put("email", TextInputEditText_signupEmail);
                jsonParam.put("name", TextInputEditText_name);
                new HttpJSONRequest(url, jsonParam).execute();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };
}
