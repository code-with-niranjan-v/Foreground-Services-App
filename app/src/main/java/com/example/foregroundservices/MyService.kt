package com.example.foregroundservices

import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.IBinder
import androidx.core.app.NotificationCompat


class MyService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            State.START.toString() -> startService()
            State.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)


    }

    enum class State{
        START,STOP
    }

    private fun startService(){
        val notification = NotificationCompat.Builder(
            this,
            "MyChannel"
        ).setContentTitle("My Service")
            .setContentText("Starting Service")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()
        startForeground(1,notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK)
        for(i in 1..10){
            Thread.sleep(1000)
            updateNotification("New Content is $i")
        }



    }

    private fun updateNotification(text:String){
        val notification = NotificationCompat.Builder(
            this,
            "MyChannel"
        ).setContentTitle("My Service")
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setSilent(true)
            .build()

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1,notification)
    }




}