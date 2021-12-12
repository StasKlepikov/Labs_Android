package com.example.lab1

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.lab1.databinding.ActivityMainBinding
import com.mongodb.stitch.android.core.Stitch
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient
import com.mongodb.stitch.core.auth.providers.anonymous.AnonymousCredential
import org.bson.Document
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var mediaPlayer: MediaPlayer = MediaPlayer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val audioUrl = "https://s4.xn--41a.wiki/10/52770_9380100b69a2d7be59a0994974f3ca3a.mp3?filename=muzyka-dlya-fona_-_skazochnaya-muzyka.mp3"
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer.setDataSource(audioUrl)
        mediaPlayer.prepare()

        //
        Stitch.initializeDefaultAppClient(
            resources.getString(R.string.app_name)
        )

        val stitchAppClient = Stitch.getDefaultAppClient()
        stitchAppClient.auth.loginWithCredential(AnonymousCredential())
            .addOnSuccessListener {
                System.out.println("Connected!")
            }
        val mongoClient = stitchAppClient.getServiceClient(
            RemoteMongoClient.factory,
            "mongodb-atlas"
        )
        val myCollection = mongoClient.getDatabase("AndroidDB")
            .getCollection("results")

        val myFirstDocument = Document()
        myFirstDocument["testfield"] = "123"
        myCollection.insertOne(myFirstDocument)
            .addOnSuccessListener {
               System.out.println("Created!")
            }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, FragmentCalc.newInstance())
            .commit()

        binding.btnPlay.setOnClickListener {
            playAudio()
        }

        binding.btnStop.setOnClickListener {
            stopAudio()
        }

        binding.btnVideo.setOnClickListener {
            val intent = Intent(this@MainActivity, Media::class.java)
            startActivity(intent)
        }

        binding.btnCalc.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, FragmentCalc.newInstance())
                .commit()
        }

        binding.btnHistory.setOnClickListener {
            val intent = Intent(this@MainActivity, History::class.java)
            startActivity(intent)
        }

        binding.btnInfo.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, FragmentInfo.newInstance())
                .commit()
        }
    }

    private fun playAudio() {

        try {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Music is already playing", Toast.LENGTH_SHORT).show()
            }
        }catch (e: IOException){
            e.printStackTrace()

        }catch (e: IOException){
            e.printStackTrace()
        }
        Toast.makeText(this, "Music started playing!", Toast.LENGTH_SHORT).show()
    }

    private fun stopAudio() {
        if (mediaPlayer.isPlaying){
            mediaPlayer.pause()

        }
        else{
            Toast.makeText(this, "Music has not played!", Toast.LENGTH_SHORT).show()
        }
    }
}