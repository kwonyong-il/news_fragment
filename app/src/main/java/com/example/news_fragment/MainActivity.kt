package com.example.news_fragment

import TitleFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().replace(R.id.fragment,TitleFragment()).commit()

    }
}