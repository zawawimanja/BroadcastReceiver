/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.fundamentals.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.ContactsContract;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * The Power Receiver app responds to system broadcasts about the power
 * connected state as well as a custom broadcast that is sent when the user
 * taps the button.
 */
public class MainActivity extends AppCompatActivity {

    private Main2Activity.MyBroadcastReceiver mReceiver= new Main2Activity.MyBroadcastReceiver();

    private Main3Activity.MyBroadcastReceiver mDisconnectActionBroadcastReceiver= new Main3Activity.MyBroadcastReceiver();

    // String constant that defines the custom broadcast Action.
    public static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    final static String BTCHAT_ACTIVITY_ACTION = "BTCHAT_ACTIVITY_ACTION";
    public static final String  TAG ="blinkyactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define the IntentFilter.
        IntentFilter filter = new IntentFilter();
        // Add system broadcast actions sent by the system when the power is
        // connected and disconnected.
//        filter.addAction(Intent.ACTION_POWER_CONNECTED);
//        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
//        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        filter.addAction(ACTION_CUSTOM_BROADCAST);
        //sendbroadcast
//        filter.addAction("com.example.broadcast.MY_NOTIFICATION");

        filter.addAction(TAG);
        // Register the receiver using the activity context, passing in the
        // IntentFilter.
        this.registerReceiver(mReceiver, filter);

      registerReceiver(mDisconnectActionBroadcastReceiver, filter);

        // Register the receiver to receive custom broadcast.
//        LocalBroadcastManager.getInstance(this).registerReceiver
//                (mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
//        LocalBroadcastManager.getInstance(this).registerReceiver
//                (mReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
//        LocalBroadcastManager.getInstance(this).registerReceiver
//                (mReceiver, new IntentFilter("com.example.broadcast.MY_NOTIFICATION"));

//        LocalBroadcastManager.getInstance(this).registerReceiver
//                (mDisconnectActionBroadcastReceiver, new IntentFilter(TAG));
//
//        LocalBroadcastManager.getInstance(this).registerReceiver
//                (mReceiver, new IntentFilter(TAG));
//
//
//

        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//      intent.setAction(ACTION_CUSTOM_BROADCAST);
//        intent.setAction(BTCHAT_ACTIVITY_ACTION);
//        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
        intent.setAction(TAG);
        intent.putExtra("data","Notice me senpai!");
        sendBroadcast(intent);
    }

    /**
     * Click event handler for the button, that sends custom broadcast using the
     * LocalBroadcastManager.
     */
    public void sendCustomBroadcast(View view) {
//        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
//        customBroadcastIntent.setAction("com.example.broadcast.MY_NOTIFICATION");
//        LocalBroadcastManager.getInstance(this)
//                .sendBroadcast(customBroadcastIntent);



//        Intent intent = new Intent();
////        intent.setAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
////      intent.setAction(ACTION_CUSTOM_BROADCAST);
////        intent.setAction(BTCHAT_ACTIVITY_ACTION);
////        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
//        intent.setAction(TAG);
//        intent.putExtra("data","Notice me senpai!");
//        sendBroadcast(intent);
    }


    public void sendCustomBroadcast1(View view) {



        Intent dash = new Intent(getApplicationContext(), Main3Activity.class);
        startActivity(dash);


//        Intent intent = new Intent();
//        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
//        intent.putExtra("data","Notice me senpai!");
//        sendBroadcast(intent);
    }



    public void sendCustomBroadcast2(View view) {



        Intent dash = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(dash);


//        Intent intent = new Intent();
//        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
//        intent.putExtra("data","Notice me senpai!");
//        sendBroadcast(intent);
    }

    /**
     * Unregisters the broadcast receivers when the app is destroyed.
     */
//    @Override
//    protected void onDestroy() {
//        // Unregister the receivers.
//        this.unregisterReceiver(mReceiver);
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
//        super.onDestroy();
//    }


//    class MyBroadcastReceiver extends BroadcastReceiver {
//        private static final String ACTION_CUSTOM_BROADCAST =
//                BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
//        private static final String TAG = "MyBroadcastReceiver";
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String intentAction = intent.getAction();
//
//            if (intentAction != null) {
//                String toastMessage = context.getString(R.string.unknown_action);
//                switch (intentAction){
//                    case Intent.ACTION_POWER_CONNECTED:
//                        toastMessage = context.getString(R.string.power_connected);
//                        break;
//                    case Intent.ACTION_POWER_DISCONNECTED:
//                        toastMessage =
//                                context.getString(R.string.power_disconnected);
//                        break;
//                    case ACTION_CUSTOM_BROADCAST:
//                        toastMessage =
//                                context.getString(R.string.custom_broadcast_toast);
//                        break;
//
//                    case Intent.ACTION_AIRPLANE_MODE_CHANGED:
//                        toastMessage =
//                                context.getString(R.string.plane);
//                        break;
//
//
//                    case "com.example.broadcast.MY_NOTIFICATION":
//                        toastMessage =
//                                context.getString(R.string.noti);
//
//                        String id = intent.getStringExtra("data");
//                        Log.i(TAG,"DATA"+id);
//                        break;
//                }
//
//                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
//            }
//        }
//    }




}


