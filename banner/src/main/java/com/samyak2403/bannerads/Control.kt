/*
 * Created by Samyak Kamble on 8/11/24, 8:29 PM
 * Copyright (c) 2024. All rights reserved.
 * Last modified 8/11/24, 8:29 PM
 */

package com.samyak2403.bannerads

import android.app.Activity
import android.util.DisplayMetrics
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

class Control(private val activity: Activity) {

    // Function to load and display a banner ad in the specified LinearLayout
    fun loadBannerAd(linearLayoutId: Int, adUnitId: String) {
        // Find the LinearLayout by ID
        val linearLayout: LinearLayout? = activity.findViewById(linearLayoutId)
        if (linearLayout != null) {
            // Create a new AdView instance
            val adView = AdView(activity)
            // Set the ad unit ID
            adView.adUnitId = adUnitId

            // Get the appropriate ad size for the device
            val adSize = getAdSize()
            adView.setAdSize(adSize)

            // Add the AdView to the LinearLayout
            linearLayout.addView(adView)
            // Set up an AdListener to handle ad events
            adView.adListener = object : AdListener() {
                override fun onAdClicked() {
                    super.onAdClicked()
                    // Called when the user clicks on the ad
                }

                override fun onAdClosed() {
                    super.onAdClosed()
                    // Called when the ad is closed
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    super.onAdFailedToLoad(loadAdError)
                    // Called when the ad fails to load
                 
                    // Uncomment the line below to show a Toast message when the ad fails to load

                    // Toast.makeText(activity, "Ad Failed", Toast.LENGTH_SHORT).show()
                }

                override fun onAdImpression() {
                    super.onAdImpression()
                    // Called when an impression is recorded for the ad

                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    // Called when the ad has finished loading
                }

                override fun onAdOpened() {
                    super.onAdOpened()
                    // Called when the ad is opened

                }
            }
            // Create an ad request and load the ad
            val adRequest = AdRequest.Builder().build()
            adView.loadAd(adRequest)
        } else {
            // Show a Toast message if the LinearLayout was not found
            Toast.makeText(activity, "LinearLayout not found", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to get the appropriate ad size based on the device's screen width and density
    private fun getAdSize(): AdSize {
        val outMetrics = DisplayMetrics()
        // Get the display metrics of the device
        activity.windowManager.defaultDisplay.getMetrics(outMetrics)
        val density = outMetrics.density

        // Calculate the ad width in pixels
        val adWidthPixels = outMetrics.widthPixels.toFloat()
        // Convert pixels to dp (density-independent pixels)
        val adWidth = (adWidthPixels / density).toInt()

        // Return the ad size based on the current orientation and ad width
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth)
    }
}

///*
// * Created by Samyak kamble on 8/11/24, 8:29 PM
// *  Copyright (c) 2024 . All rights reserved.
// *  Last modified 8/11/24, 8:29 PM
// */
//
//package com.samyak2403.bannerads
//
//
//
//import android.app.Activity
//import android.util.DisplayMetrics
//import android.widget.LinearLayout
//import android.widget.Toast
//import com.google.android.gms.ads.AdListener
//import com.google.android.gms.ads.AdRequest
//import com.google.android.gms.ads.AdSize
//import com.google.android.gms.ads.AdView
//import com.google.android.gms.ads.LoadAdError
//
//class Control(private val activity: Activity) {
//
//    fun loadBannerAd(linearLayoutId: Int, adUnitId: String) {
//        val linearLayout: LinearLayout? = activity.findViewById(linearLayoutId)
//        if (linearLayout != null) {
//            val adView = AdView(activity)
//            adView.adUnitId = adUnitId
//
//            val adSize = getAdSize()
//            adView.setAdSize(adSize)
//
//            linearLayout.addView(adView)
//            adView.adListener = object : AdListener() {
//                override fun onAdClicked() {
//                    super.onAdClicked()
//                }
//
//                override fun onAdClosed() {
//                    super.onAdClosed()
//                }
//
//                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
//                    super.onAdFailedToLoad(loadAdError)
//                    // Toast.makeText(activity, "Ad Failed", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onAdImpression() {
//                    super.onAdImpression()
//                }
//
//                override fun onAdLoaded() {
//                    super.onAdLoaded()
//                }
//
//                override fun onAdOpened() {
//                    super.onAdOpened()
//                }
//            }
//            val adRequest = AdRequest.Builder().build()
//            adView.loadAd(adRequest)
//        } else {
//            Toast.makeText(activity, "LinearLayout not found", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun getAdSize(): AdSize {
//        val outMetrics = DisplayMetrics()
//        activity.windowManager.defaultDisplay.getMetrics(outMetrics)
//        val density = outMetrics.density
//
//        val adWidthPixels = outMetrics.widthPixels.toFloat()
//        val adWidth = (adWidthPixels / density).toInt()
//
//        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth)
//    }
//}
