package com.example.secure;

import static androidx.core.app.ActivityCompat.*;
import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

public class Permissions {
    private static final int REQUEST_CODE_PERMISSIONS = 2;

    // Storage Permissions variables
    private static final String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    //check permissions.
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_DENIED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // request for permission
            requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_CODE_PERMISSIONS);
        }
    }
}
