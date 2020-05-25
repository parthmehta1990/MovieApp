package com.example.dummymovieapp.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.bumptech.glide.util.Util
import com.example.dummymovieapp.R
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import javax.sql.DataSource


class MoviePlayerActivity : AppCompatActivity() {

    lateinit var playerView: PlayerView
    lateinit var simpleExoPlaer: SimpleExoPlayer
    lateinit var videoUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFullScreen()
        setContentView(R.layout.activity_movie_player)

        videoUrl =
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

        initPlayer()

    }

    private fun setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //Hiding Actionbar
        supportActionBar?.hide()

    }

    private fun initPlayer() {
        playerView = findViewById(R.id.movie_exo_player)

        val trackSelector = DefaultTrackSelector()

        simpleExoPlaer = ExoPlayerFactory.newSimpleInstance(this)

        playerView.player = simpleExoPlaer

        var datasource = DefaultDataSourceFactory(
            this,
            com.google.android.exoplayer2.util.Util.getUserAgent(this, "DummyMovieApp")
        )

        var mediaSOurce: MediaSource = ExtractorMediaSource.Factory(datasource)
            .createMediaSource(Uri.parse(videoUrl))

        simpleExoPlaer.prepare(mediaSOurce)
        simpleExoPlaer.playWhenReady = true


    }

    override fun onDestroy() {
        super.onDestroy()

        simpleExoPlaer.release()
    }
}
