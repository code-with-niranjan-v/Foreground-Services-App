package com.example.foregroundservices

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.foregroundservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnStart.setOnClickListener {
            Intent(applicationContext,MyService::class.java).also {
                it.action = MyService.State.START.toString()
                startService(it)
            }
        }

        binding.btnStop.setOnClickListener {
            Intent(applicationContext,MyService::class.java).also {
                it.action = MyService.State.STOP.toString()
                startService(it)
            }
        }

    }


}