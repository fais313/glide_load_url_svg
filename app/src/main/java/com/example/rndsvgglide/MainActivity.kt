package com.example.rndsvgglide

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.rndsvgglide.databinding.ActivityMainBinding
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    private lateinit var bindingView: ActivityMainBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingView.root)
        val uriJpeg = Uri.parse("https://image.shutterstock.com/image-illustration/jpeg-file-document-icon-trendy-260nw-1390078610.jpg")
        val uriPng = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Home_Icon_by_Lakas.svg/1200px-Home_Icon_by_Lakas.png")
        val uriSvg = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/2/21/Speaker_Icon.svg")

        Glide.with(this)
            .load(uriPng)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .override(iconSize(36))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(bindingView.iconView0)

      /*  Glide.with(this)
            .load(uriSvg)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .override(iconSize(36))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(bindingView.iconView1)

        Glide.with(this)
            .load(uriJpeg)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .override(iconSize(36))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(bindingView.iconView2)

        Glide.with(this)
            .load(R.drawable.ic_samples)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .override(iconSize(36))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(bindingView.iconView3)*/
    }

    private fun iconSize(iconSize: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, iconSize.toFloat(), resources.displayMetrics
        ).roundToInt()
    }
}