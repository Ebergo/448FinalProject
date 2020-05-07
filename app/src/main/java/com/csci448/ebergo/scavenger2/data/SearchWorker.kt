package com.csci448.ebergo.scavenger2.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.concurrent.futures.CallbackToFutureAdapter
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.csci448.ebergo.scavenger2.MainActivity
import com.csci448.ebergo.scavenger2.R
import com.google.common.util.concurrent.ListenableFuture


const val logTag = "448.LocatrWorker"

class SearchWorker(private val context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {
    override fun doWork(): Result {
        val notificationManager = NotificationManagerCompat.from(context)
        val channelID = context.resources.getString(R.string.notification_channel_id)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // version is Oreo or higher
            // version is API 26 or higher
            // version is Android 8.0 or higher
            val channel = NotificationChannel(channelID,
                R.string.notification_channel_name.toString(),
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = R.string.notification_channel_desc.toString()
            }
            notificationManager.createNotificationChannel(channel)
        }
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val notification = NotificationCompat.Builder(context, channelID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(context.getString(R.string.notification_title))
            .setContentText("Found 15 laptops in your area")
            .setAutoCancel(false)
            .setContentIntent(pendingIntent)
            .build()
        notificationManager.notify(0, notification)
        return Result.success()
    }

}