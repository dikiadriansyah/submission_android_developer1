package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailAkun: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_detail_diri)

        val actionBar = supportActionBar
        actionBar!!.title = "About"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val imgMe: ImageView = findViewById(R.id.img_item_detail_diri)
        val tImg = "https://pbs.twimg.com/profile_images/669707714474283009/DwnEh7dP_400x400.jpg"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}