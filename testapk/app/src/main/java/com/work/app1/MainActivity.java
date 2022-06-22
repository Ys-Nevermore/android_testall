package com.work.app1;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_start;
    private Button btn_close;
    private Button btn_pkg;
    private Button btn_swipe;
    private Button btn_prop;
    private EditText editTextProp;
    private EditText editTextValue;
    private String packname = "com.work.test2";
    private final String TAG = "mybroadcast";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }
    private void initUI( ) {
        editTextProp = findViewById(R.id.editTextProp);
        editTextValue = findViewById(R.id.editTextValue);
        btn_start = findViewById(R.id.btnStart);
        btn_close =  findViewById(R.id.btnCLose);
        btn_pkg =findViewById(R.id.btnPKG);
        btn_swipe = findViewById(R.id.btnPKG2);
        btn_prop = findViewById(R.id.btnProp);
        btn_pkg.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        btn_swipe.setOnClickListener(this);
        btn_prop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                Intent intent = new Intent("android.intent.action.SHOW_SYSTEM_BAR");
                Log.i(TAG, "android.intent.action.SHOW_SYSTEM_BAR");
                sendBroadcast(intent);
                break;
            case R.id.btnCLose:
                Intent intent2=new Intent("android.intent.action.HIDE_SYSTEM_BAR");
                Log.i(TAG, "android.intent.action.HIDE_SYSTEM_BAR");
                sendBroadcast(intent2);
                break;
            case R.id.btnPKG:
                Log.i(TAG, "send SWIPED_SYSTEM_BAR bar:2");
                Intent intent3=new Intent("android.intent.action.SWIPED_SYSTEM_BAR");
                intent3.putExtra("bar", 2);
                sendBroadcast(intent3);
                break;
            case R.id.btnPKG2:
                Log.i(TAG, "send SWIPED_SYSTEM_BAR bar:3");
                Intent intent4=new Intent("android.intent.action.SWIPED_SYSTEM_BAR");
                intent4.putExtra("bar", 3);
                sendBroadcast(intent4);
                break;
            case R.id.btnProp:
                Log.i(TAG, "set prop:" + editTextProp.getText() + "  " + editTextValue.getText());
                Intent intent5=new Intent("android.intent.action.PROPERTY");
                intent5.putExtra("prop", editTextProp.getText());
                intent5.putExtra("value", editTextValue.getText());
                sendBroadcast(intent5);
                break;
            default:
                break;
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
