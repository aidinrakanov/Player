package com.example.player.ui.player

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.player.R
import com.example.player.model.PlayerModel

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
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