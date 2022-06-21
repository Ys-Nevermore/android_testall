package com.work.app1;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_start;
    private Button btn_close;
    private Button btn_pkg;
    private Button btn_swipe;
    private String packname = "com.work.test2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.btnStart);
        btn_close =  findViewById(R.id.btnCLose);
        btn_pkg =findViewById(R.id.btnPKG);
        btn_swipe = findViewById(R.id.btnPKG2);
        btn_pkg.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        btn_swipe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
               // Intent intent=new Intent("360_camera_start");
                Intent intent = new Intent("android.intent.action.SHOW_SYSTEM_BAR");
                Log.i("mylog", "start 360");
                sendBroadcast(intent);
                break;
            case R.id.btnCLose:
                Intent intent2=new Intent("android.intent.action.HIDE_SYSTEM_BAR");
                Log.i("mylog", "start 360");
                sendBroadcast(intent2);
                break;
            case R.id.btnPKG:
                Log.i("mylog", "start 3603");
                Intent intent3=new Intent("android.intent.action.SWIPED_SYSTEM_BAR");
                intent3.putExtra("bar", 2);
                sendBroadcast(intent3);
                Log.i("mylog", "start 360");
              //sendBroadcast(intent2);
//                PackageManager packageManager = getPackageManager();
//                if (checkPackInfo(packname)) {
//                    Intent intent3 = packageManager.getLaunchIntentForPackage(packname);
//                    startActivity(intent3);
//                } else {
//                    Toast.makeText(MainActivity.this, "没有安装" + packname, 1).show();
//                }
                break;
            case R.id.btnPKG2:
                Log.i("mylog", "start 3603");
                Intent intent4=new Intent("android.intent.action.SWIPED_SYSTEM_BAR");
                intent4.putExtra("bar", 3);
                sendBroadcast(intent4);
                Log.i("mylog", "start 360");
        }
    }
    /**
     * 检查包是否存在
     *
     * @param packname
     * @return
     */
    private boolean checkPackInfo(String packname) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(packname, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo != null;
    }

}
