package es.source.code.activity;

import android.Manifest;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.security.Permission;


public class SCOSEntry extends AppCompatActivity  implements ActivityCompat.OnRequestPermissionsResultCallback{

    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        Log.i("SCOSEntry","1");
        SCOSDataBase sCOSDataBase = new SCOSDataBase(getBaseContext());
        sCOSDataBase.save("");//第一次进入时清空数据库，防止干扰
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN) {
            //当手指离开时
            x1 = event.getX();
            y1 = event.getY();
        }else if(event.getAction()==MotionEvent.ACTION_UP){
            //当手指离开时
            x2=event.getX();
            y2=event.getY();
            //手势判断
            if((x1 - x2) > 50){//向左滑动
                Log.i("SCOSEntry","LEFT");
                String data="FromEntry";
                Intent intent= new Intent(SCOSEntry.this,MainScreen.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        }
        return super.onTouchEvent(event);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
