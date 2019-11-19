package com.techcom.android_background_services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class IntentServices extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    private  static final String TEG=IntentService.class.getSimpleName();
    public IntentServices() {
        super("myworkerthread");
    }

    @Override
    public void onCreate() {

        super.onCreate();
        Log.i(TEG,"onCreate, Thread name: "+ Thread.currentThread().getName());
    }

    @Override
    public void onDestroy() {
        Log.i(TEG,"onDestroy, Thread name: "+ Thread.currentThread().getName());
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TEG,"onHandleIntent, Thread name: "+ Thread.currentThread().getName());
        int ctr=1;
        while( ctr<=12)
        {
            Log.i(TEG,"Times elapsed: "+ctr+"secs");
            try {
                Thread.sleep(1000);   //testing lon running operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ctr++;
        }
    }
}
