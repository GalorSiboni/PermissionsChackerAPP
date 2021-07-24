package com.example.permissionchecker;

import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.List;

public class Permission_Checker_Library {
    public static boolean checkThePermissions(Activity c, String permissionCheck) {

        List<String> permissionList =
                Arrays.asList("READ_CALENDAR", "READ_CALL_LOG", "READ_EXTERNAL_STORAGE", "WRITE_CALENDAR", "WRITE_CALL_LOG", "WRITE_EXTERNAL_STORAGE",
                        "READ_CONTACTS", "WRITE_CONTACTS", "READ_PHONE_STATE", "READ_PHONE_NUMBERS", "READ_SMS", "CALL_PHONE", "CAMERA", "GET_ACCOUNTS",
                        "ACCESS_FINE_LOCATION", "ACCESS_COARSE_LOCATION", "RECORD_AUDIO", "BODY_SENSORS", "SEND_SMS", "RECEIVE_SMS", "RECEIVE_WAP_PUSH",
                        "RECEIVE_MMS", "ADD_VOICEMAIL");


        for (int i = 0; i < permissionList.size(); i++) {
            if (permissionList.get(i).equals(permissionCheck.toUpperCase())) {
                if (ContextCompat.checkSelfPermission(c, permissionList.get(i)) != PackageManager.PERMISSION_GRANTED)
                    return true;
            }

        }
        return false;
    }
}
