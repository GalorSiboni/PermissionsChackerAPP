package com.example.permissionschackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.example.permissionchecker.Permission_Checker_Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private Button btn;
    private AutoCompleteTextView permissionsACTV;
    private ArrayList<String> permissionsAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);
        permissionsACTV = findViewById(R.id.permissionsACTV);
        List<String> list = Arrays.asList("READ_CALENDAR", "READ_CALL_LOG", "READ_EXTERNAL_STORAGE", "WRITE_CALENDAR", "WRITE_CALL_LOG", "WRITE_EXTERNAL_STORAGE",
                "READ_CONTACTS", "WRITE_CONTACTS", "READ_PHONE_STATE", "READ_PHONE_NUMBERS", "READ_SMS", "CALL_PHONE", "CAMERA", "GET_ACCOUNTS",
                "ACCESS_FINE_LOCATION", "ACCESS_COARSE_LOCATION", "RECORD_AUDIO", "BODY_SENSORS", "SEND_SMS", "RECEIVE_SMS", "RECEIVE_WAP_PUSH",
                "RECEIVE_MMS", "ADD_VOICEMAIL");
        permissionsAL = new ArrayList<>(list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, permissionsAL);
        permissionsACTV.setAdapter(adapter);
        btn.setOnClickListener(v -> {
            if(Permission_Checker_Library.checkThePermissions(this, permissionsACTV.getText().toString()))
                result.setText("Permissions granted!");
            else
                result.setText("You don't have this permissions");
            result.setVisibility(View.VISIBLE);
        });
    }
}