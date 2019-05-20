package com.sagnik.audioanimation

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.R.attr.start



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val layout = findViewById<RelativeLayout>(R.id.parent_layout)

        val animation = layout.background as AnimationDrawable?
        animation?.setEnterFadeDuration(3000)
        animation?.setExitFadeDuration(1000)
        animation?.start()


    }

    fun PlaySoundOnButtons(view: View) {

        val sound :Button = view as Button

        val mediaPlayer = MediaPlayer.create(this@MainActivity,resources.getIdentifier(sound.tag as String,"raw",packageName))


        mediaPlayer.setOnPreparedListener { mp ->
            if (mp === mediaPlayer) {
                mediaPlayer.start()

                sound.setBackgroundColor(Color.MAGENTA)
            }
            mediaPlayer.setOnCompletionListener {

                sound.setBackgroundColor(Color.BLUE)
            }

        }
    }

}