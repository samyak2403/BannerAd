package com.samyak2403.bannerads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.samyak2403.bannerads.databinding.ActivityMainBinding
import com.samyak2403.bannerads.model.UserModel


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private var data = mutableListOf<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        val control = Control(this)
        val adUnitId = getString(R.string.admob_banner_id) // Fetch the AdMob banner ID from resources
        control.loadBannerAd(R.id.bannerAdContainer, adUnitId)
    }
}