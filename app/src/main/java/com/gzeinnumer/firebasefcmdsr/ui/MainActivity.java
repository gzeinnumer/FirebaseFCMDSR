package com.gzeinnumer.firebasefcmdsr.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.gzeinnumer.firebasefcmdsr.R;
import com.gzeinnumer.firebasefcmdsr.service.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, FirebaseMessagingService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume: "+FirebaseInstanceId.getInstance().getToken());

        ((TextView)findViewById(R.id.tv)).setText(FirebaseInstanceId.getInstance().getToken());
    }
}