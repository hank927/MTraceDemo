package com.hank.mtracedemo;

import android.os.Bundle;

import com.hank.tracelib.MTrace;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_sub_thread:
                doSubThread();
                break;
            case R.id.btn_function:
                doTest();
                break;
            case R.id.btn_stop_collect:
                MTrace.endTraceMethod();
                break;
            case R.id.btn_restart_collect:
                MTrace.beginTraceMethod();
                break;
            default:
                break;
        }
    }

    /**
     * 子线程耗时实例
     *
     */
    private void doSubThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    doTest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "handleSubThread finish.");
            }
        }).start();
    }

    private void doTest(){
        Log.i(TAG, "doTest start.");
        int count = 0;
        for(int i=0;i<100;i++){
            count +=i;
        }
        Log.i(TAG, "doTest finish. count = " + count);
    }
}