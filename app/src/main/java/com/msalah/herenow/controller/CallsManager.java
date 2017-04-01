package com.msalah.herenow.controller;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;

import com.msalah.herenow.R;
import com.msalah.herenow.activities.MainActivity;
import com.msalah.herenow.model.Call;

/**
 * Created by user on 3/31/17.
 */

public class CallsManager {

    public static boolean submitCall (Call call, Context context) {

        long currentTime = System.currentTimeMillis();

        Intent notificationIntent = new Intent(context,
                MainActivity.class);



        notificationIntent.putExtra("clicked", "Notification Clicked");
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP); // To open only one activity


        // Invoking the default notification service

        NotificationManager mNotificationManager;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context);
        Uri uri = RingtoneManager
                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mBuilder.setContentTitle("Reminder");
        mBuilder.setContentText("You have new Reminders.");
        mBuilder.setTicker("New Reminder Alert!");
        mBuilder.setSmallIcon(R.drawable.icon);
        mBuilder.setSound(uri);
        mBuilder.setAutoCancel(true);

        // Add Big View Specific Configuration
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = null;

        events[0] = new String("Your first line text ");
        events[1] = new String(" Your second line text");



        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("You have Reminders:");

        // Moves events into the big view
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        mBuilder.setStyle(inboxStyle);

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context,
                MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder
                .create(context);
        stackBuilder.addParentStack(MainActivity.class);


        // Adds the Intent that starts the Activity to the top of the stack


        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_CANCEL_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);
        mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);


        // notificationID allows you to update the notification later  on.


        mNotificationManager.notify(999, mBuilder.build());

        return  true;
    }
}
