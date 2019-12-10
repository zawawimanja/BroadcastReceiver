package com.android.fundamentals.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import static com.android.fundamentals.powerreceiver.MainActivity.ACTION_CUSTOM_BROADCAST;
import static com.android.fundamentals.powerreceiver.MainActivity.BTCHAT_ACTIVITY_ACTION;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Define the IntentFilter.
        IntentFilter filter = new IntentFilter();
        // Add system broadcast actions sent by the system when the power is
        // connected and disconnected.
//        filter.addAction(Intent.ACTION_POWER_CONNECTED);
//        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
//        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        filter.addAction(ACTION_CUSTOM_BROADCAST);
//        filter.addAction(BTCHAT_ACTIVITY_ACTION);
        //sendbroadcast
        filter.addAction("com.example.broadcast.MY_NOTIFICATION");
        filter.addAction(MainActivity.TAG);


        this.registerReceiver(mReceiver, filter);



    }


    MyBroadcastReceiver mReceiver=new MyBroadcastReceiver();


    static class MyBroadcastReceiver extends BroadcastReceiver {
        private static final String ACTION_CUSTOM_BROADCAST =
                BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
        private static final String TAG1 = "MyBroadcastReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            String intentAction = intent.getAction();

            if (intentAction != null) {
                String toastMessage = context.getString(R.string.unknown_action);
                switch (intentAction){
                    case Intent.ACTION_POWER_CONNECTED:
                        toastMessage = context.getString(R.string.power_connected);
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED:
                        toastMessage =
                                context.getString(R.string.power_disconnected);
                        break;
                    case ACTION_CUSTOM_BROADCAST:
                        toastMessage =
                                context.getString(R.string.custom_broadcast_toast1);
                        Log.i(TAG1,"broadcast"+toastMessage);
                        break;

                    case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                        toastMessage =
                                context.getString(R.string.plane1);
                        break;


                    case MainActivity.TAG:
                        toastMessage =
                                context.getString(R.string.noti);

                        String id = intent.getStringExtra("data");
                        Log.i(TAG1,"DATATOM3"+id);
                        break;
                }

                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Unregister broadcast receivers
        unregisterReceiver(mReceiver);


    }
}
