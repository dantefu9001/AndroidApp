package com.zn.thirdapp.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.zn.thirdapp.R

class MusicPlayService : Service() {

    private var mTagName = "Music Play Service"

    lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return MediaPlayerBinder()
    }

    override fun onCreate() {
        super.onCreate()
        initMediaPlayer()
        Log.i(mTagName, "Music player created")
    }

    private fun initMediaPlayer() {
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.test)
            mediaPlayer.prepare()
        } catch (e: Exception) {
            stopSelf()
        }
    }

    fun play() {
        Log.i(mTagName, "Playing music")
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    fun pause() {
        Log.i(mTagName, "Music paused")
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    fun stop(){
        Log.i(mTagName, "Music stopped")
        mediaPlayer.stop()
    }

    fun release(){
        Log.i(mTagName, "Music player released")
        mediaPlayer.release()
    }

    inner class MediaPlayerBinder : Binder() {
        fun getService(): MusicPlayService = this@MusicPlayService
    }
}