package com.example.solarsystem;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();

            if ("PLAY_MUSIC".equals(action)) {
                int musicResId = intent.getIntExtra("musicResId", 0);
                playMusic(musicResId);
                // Show notification when music starts
                sendNotification("Lecture en cours");
            } else if ("PAUSE_MUSIC".equals(action)) {
                pauseMusic();
                sendNotification("Musique en pause");
            } else if ("RESUME_MUSIC".equals(action)) {
                resumeMusic();
                sendNotification("Lecture reprise");
            } else if ("STOP_MUSIC".equals(action)) {
                stopMusic();
                stopSelf();
                return START_NOT_STICKY; // Stops the service without restarting
            }
        }
        return START_STICKY;
    }

    private void playMusic(int musicResId) {
        // Stop the previous music if necessary
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        if (musicResId != 0) {
            mediaPlayer = MediaPlayer.create(this, musicResId);
            mediaPlayer.setLooping(true); // Loop playback
            mediaPlayer.start();
        }
    }
    private void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }
    private void resumeMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }
    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void sendNotification(String message) {
        Intent notificationIntent = new Intent(this, NotificationService.class);
        notificationIntent.putExtra("message", message);
        startService(notificationIntent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    /**
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
