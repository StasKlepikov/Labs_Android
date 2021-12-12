package com.example.lab1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.MediaController


import com.example.lab1.databinding.ActivityMediaBinding
import kotlinx.android.synthetic.main.activity_media.*

class Media : AppCompatActivity() {

    lateinit var binding: ActivityMediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)

//      val onlineUri = Uri.parse("https://cdn.videvo.net/videvo_files/video/free/2021-04/large_watermarked/210329_06B_Bali_1080p_013_preview.mp4")
        val onlineUri = Uri.parse("android.resource://$packageName//${R.raw.videofile}")
        video.setVideoURI(onlineUri)
        video.requestFocus()
        video.start()

        binding.video.setMediaController(mediaController)
        mediaController.setAnchorView(video)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "History"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}