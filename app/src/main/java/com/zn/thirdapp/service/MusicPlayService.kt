package com.zn.thirdapp.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.zn.thirdapp.R
import java.io.File
import java.lang.Exception
import kotlin.random.Random

class MusicPlayService : Service() {

    lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return MediaPlayerBinder()
    }

    override fun onCreate() {
        super.onCreate()
        initMediaPlayer()
        println("Music player created")
    }

    private fun initMediaPlayer() {
        try {
            mediaPlayer = MediaPlayer.create(this,R.raw.test)
            mediaPlayer.prepare()
        } catch (e: Exception) {
            stopSelf()
        }
    }

    fun play() {
        println("Playing music")
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    fun pause() {
        println("Playing paused")
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    inner class MediaPlayerBinder : Binder() {

        fun getService(): MusicPlayService = this@MusicPlayService
    }
}