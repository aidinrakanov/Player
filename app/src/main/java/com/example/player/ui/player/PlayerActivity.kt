package com.example.player.ui.player

import android.app.Activity
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.player.R
import com.example.player.extension.loadImage
import com.example.player.model.PlayerModel
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    private var flag: Boolean = true
    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        setUpListeners()
        seekbarChange()
        initial()
        getNames()

    }

    private fun initial() {
        seekbar.max= mediaPlayer.duration
        val handler = Handler()
        handler.postDelayed(object : Runnable{
            override fun run() {
                try {
                    seekbar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e : Exception){
                    seekbar.progress = 0
                }

            }
        },0)
    }

    private fun getNames(){
        song_name_player.text = item?.song
        artist_name_player.text = item?.artists
        image_player.loadImage(item?.coverImage, R.drawable.song_image )
    }


    private fun seekbarChange() {
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2)mediaPlayer.seekTo(p1)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }

    private fun setUpListeners() {
        play.setOnClickListener {
            if (flag){
                mediaPlayer.pause()
                play.setImageResource(R.drawable.ic_play)
            }else{
                mediaPlayer.start()
                play.setImageResource(R.drawable.ic_pause)
            }
            flag = !flag
        }
    }


    val url = item?.url
    val mediaPlayer: MediaPlayer = MediaPlayer().apply {
        setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        )
        setDataSource(url)
        prepare()
        start()
    }


    companion object {
        private var item: PlayerModel? = null
        fun instanceStart(activity: Activity?, item: PlayerModel) {
            this.item = item
            val intent = Intent(activity, PlayerActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}