package com.tony_fire.tesla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.firebase.messaging.FirebaseMessaging
import com.tony_fire.tesla.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var player : SimpleExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        player = SimpleExoPlayer.Builder(this).build()
        videoPlayer()
        binding.button.setOnClickListener {
            FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@addOnCompleteListener
                }
                val token2 = task.result
                Log.d("Token", "Token: + $token2" )
            }
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        binding.videoView.player = player
        player.pause()

    }

    override fun onStop() {
        super.onStop()
        binding.videoView.player = player
        player.pause()

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.videoView.player = player
        player.pause()
    }

    private fun videoPlayer() {
        val mediaItem: MediaItem = MediaItem.fromUri("http://drive.google.com/file/d/1rsbF7S3pIa3WZ3n6eKqmSSZXayO-aOMd/view")
        binding.videoView.player = player
        binding.videoView.setShowBuffering(PlayerView.SHOW_BUFFERING_WHEN_PLAYING)
        player.setMediaItem(mediaItem)
        player.prepare()



    }
}