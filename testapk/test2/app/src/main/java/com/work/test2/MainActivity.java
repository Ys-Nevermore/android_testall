package com.work.test2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mylog";
    public static final String ACTION_360_START="360_camera_start";
    public static final String ACTION_360_STOP="360_camera_stop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.dimple.MY_BROADCAST");
        registerReceiver(cameraReceiver,intentFilter);

    }
        private final BroadcastReceiver cameraReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (ACTION_360_START.equals(action)) {
                    Log.i(TAG, "camera receive start action--------------");
                } else if (ACTION_360_STOP.equals(action)) {
                    Log.i(TAG, "camera receive close action--------------");
                    finish();
                }
            }
        };

    @Override
    protected void onDestroy() {

        super.onDestroy();
        unregisterReceiver(cameraReceiver);
    }
}
