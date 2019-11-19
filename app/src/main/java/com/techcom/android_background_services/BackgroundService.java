package com.techcom.android_background_services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BackgroundService extends Service {
    myasyncTasks myasyncTasks;
    private  static final String TEG=BackgroundService.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
        Log.i(TEG,"onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TEG,"onBind");
        Toast.makeText(getApplicationContext(),"onBind",Toast.LENGTH_SHORT).show();
        return null;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TEG,"onStartCommand");
        Toast.makeText(getApplicationContext(),"onStartCommand",Toast.LENGTH_SHORT).show();
        myasyncTasks= new myasyncTasks();
               myasyncTasks.execute(); // run in background thread
        return START_STICKY;


    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.i(TEG,"onDestroy");
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
        myasyncTasks.cancel(true);


    }
    class myasyncTasks extends AsyncTask<Void,String,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TEG,"onPreExecute");
        }

        @Override // background operation performed here

        protected Void doInBackground(Void... voids) {
            Log.i(TEG,"doInBackground");
          //  Toast.makeText(getApplicationContext(),"doInBackground"+Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();
            int ctr=1;
            while( ctr<=12)
            {
                publishProgress("Times elapsed: "+ctr+"secs");
                try {
                    Thread.sleep(1000);   //testing lon running operation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctr++;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i(TEG,"onPostExecute");
            Toast.makeText(getApplicationContext(),"onPostExecute"+Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();
            super.onPostExecute(aVoid);

        }

        @Override
        protected void onProgressUpdate(String... values) {

      //      Toast.makeText(getApplicationContext(),"onProgressUpdateer"+Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();
            super.onProgressUpdate(values);
            Toast.makeText(getApplicationContext(),values[0],Toast.LENGTH_SHORT).show();
            Log.i(TEG,"onProgressUpdate");
        }
    }
}
