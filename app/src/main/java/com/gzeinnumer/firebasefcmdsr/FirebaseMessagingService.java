package com.gzeinnumer.firebasefcmdsr;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private final String TAG = getClass().getSimpleName();

    public FirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        sendNotif(remoteMessage);
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }

    private void sendNotif(RemoteMessage remoteMessage) {
        Log.e(TAG, "sendNotif: " + remoteMessage.getData().get("id"));
        Log.e(TAG, "sendNotif: " + remoteMessage.getNotification().getTitle());
        Log.e(TAG, "sendNotif: " + remoteMessage.getNotification().getBody());

        final NotificationHelper notificationHelper = new NotificationHelper(this);
        notificationHelper.createNotification("Reminder", "Apakah anda sudah mengisi DSR hari ini?");
    }
}