package com.hank.mtracedemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import com.hank.tracelib.BuildConfig;
import com.hank.tracelib.MTrace;

import java.util.Map;

public class TraceApplication extends Application {
    private static final String TAG = "TraceApplication";
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        initTrace();
    }

    private void initTrace() {
        MTrace.beginTraceMethod();
        MTrace.init(this);
        MTrace.setThresold(-1);
    }

    public static Context getContext() {
        if (mContext == null) {
            throw new RuntimeException("Unknown Error");
        }
        return mContext;
    }
}
