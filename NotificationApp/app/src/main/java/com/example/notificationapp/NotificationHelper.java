package com.example.notificationapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper {

    Context ctx;
    NotificationManager manager;
    NotificationCompat.Builder builder;
    NotificationChannel channel;
    int notifyId=0;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationHelper(Context ctx){
        this.ctx = ctx;
        manager =  (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        channel = new NotificationChannel(
                "Mynotification",
                "My Notification App",
                NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);
    }

    void createBuilder(String title,String subtitle){
        builder = new NotificationCompat.Builder(ctx,"Mynotification");
        builder
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(subtitle).build();
    }

    void sendNotification(){
        Notification notification = builder.build();
        notifyId++;
        manager.notify(notifyId,notification);
    }


    void Type1Notification(String title,String subtitle){
        createBuilder(title,subtitle);
        sendNotification();
    }

    void Type2Notification(String title,String subtitle){
        createBuilder(title,subtitle);
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.addLine("This is from mca rollwala");
        inboxStyle.addLine("This is from jyoti parikh ma'am");
        inboxStyle.addLine("Hello boi");
        builder.setStyle(inboxStyle);
        sendNotification();
    }

    void clearNotificaitons(){
        if (manager!=null){
            notifyId=0;
            manager.cancelAll();
        }
    }


}
