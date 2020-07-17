package com.example.bumpapp;
import com.example.bumpapp.IBumpAPI;
import com.example.bumpapp.BumpAPIIntents;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.content.Intent;
import android.util.Log;

public class BumpTest {
    //Bind to the Bump Service
    private IBumpAPI api;
    private final ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder binder){
            api = (IBumpAPI) IBumpAPI.Stub.asInterface(binder);
            api.configure("your_api_key", "Bump User");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("Bump Test", "Service Disconnected");
        }

    };
    //Set up a BroadCast Receiver
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (action.equals(BumpAPIIntents.DATA_RECEIVED)){
                Log.i("Bump Test", "Received data from: " + api.userIDForChannelID(intent.getLongExtra("channelID", 0)));
                Log.i("Bump Test", "Data: " + new String(intent.getByteArrayExtra("data")));
            } else if(action.equals(BumpAPIIntents.MATCHED)) {
                api.confirm(intent.getLongExtra("proposedChannelID", 0), true);
            } else if(action.equals(BumpAPIIntents.CHANNEL_CONFIRMED)){
                api.send(intent.getLongExtra("channelID", 0), "Hello, world!".getBytes());
            }else if(action.equals(BumpAPIIntents.CONNECTED)){
                api.enableBumping();
            }
        }
    };
    //Intent Filter
    private Object IntentFilter;

    //Add Bump bindService Intents
    public void onCreate(Bundle savedInstanceState) {
        //super.equals(savedInstanceState);
        bindService(new Intent(IBumpAPI.class.getName()),
                connection, Context.BIND_AUTO_CREATE);
        Log.i("Bump Test", "boot");
        IntentFilter filter = new IntentFilter();
        filter.addAction(BumpAPIIntents.CHANNEL_CONFIRMED);
        filter.addAction(BumpAPIIntents.DATA_RECEIVED);
        filter.addAction(BumpAPIIntents.NOT_MATCHED);
        filter.addAction(BumpAPIIntents.MATCHED);
        filter.addAction(BumpAPIIntents.CONNECTED);
        registerReceiver(receiver, filter);
    }

    private void bindService(Intent intent, ServiceConnection connection, int bindAutoCreate) {
        new Intent("intent");
    }

    private void registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        IntentFilter = new IntentFilter();
    }
}
