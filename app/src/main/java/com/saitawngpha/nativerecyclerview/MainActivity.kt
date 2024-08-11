package com.saitawngpha.nativerecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.saitawngpha.nativerecyclerview.databinding.ActivityMainBinding
import com.saitawngpha.nativerecyclerview.model.UserModel
import com.samyak2403.bannerads.Control


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