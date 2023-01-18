package com.example.zulfin.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class NotificationHelper {

    Context ctx;
    NotificationManager manager;
    NotificationChannel channel;
    NotificationCompat.Builder builder;
    int notifyId = 0;

    public  NotificationHelper(Context ctx) {

        this.ctx = ctx;
        manager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            channel = new NotificationChannel("MyNotification", "My Notifications App", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
    }

    void createBuilder(String title, String message) {
        builder = new NotificationCompat.Builder(ctx, "MyNotification");
        builder.setSmallIcon(R.drawable.ic_notifications).setContentTitle(title).setContentText(message);

    }

    void sendNotification(){
        Notification notification = builder.build();
        notifyId++;
        manager.notify(notifyId, notification);
    }
    void Type1Notification(String title, String message) {
        createBuilder(title, message);
        sendNotification();
    }

    void Type2Notification(String title, String message) {
        createBuilder(title, message);
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Expandable Inbox");
        inboxStyle.addLine("You have 2 messages.");
        inboxStyle.addLine("Message from Rollwala");
        inboxStyle.addLine("Message from GU");

        builder.setStyle(inboxStyle);
        sendNotification();
    }

    void Type3Notification(String title, String message) {
        createBuilder(title, message);
        Intent intent1 = new Intent(ctx, SecondActivity.class);
        intent1.setAction("Ok Clicked");

        PendingIntent PI = PendingIntent.getActivity(ctx, 1, intent1, 1);
        builder.addAction(R.drawable.ic_notifications, "OK", PI);

        Intent intent2 = new Intent(ctx, SecondActivity.class);
        intent2.setAction(" Not Ok Clicked");

        PendingIntent PI2 = PendingIntent.getActivity(ctx, 1, intent2, 1);
        builder.addAction(R.mipmap.ic_launcher, "Not OK", PI2);

        sendNotification();
    }

    void clearNotification() {
        if(manager != null){
            notifyId = 0;
            manager.cancelAll();
        }
    }
}
