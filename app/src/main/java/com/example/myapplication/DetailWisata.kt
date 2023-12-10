package com.example.myapplication

import android.bluetooth.BluetoothDevice.EXTRA_NAME
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailWisata: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_detail_wisata)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Wisata"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_judul_wisata)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetSubDetail1: TextView = findViewById(R.id.tv_set_detail)
        val tvSetDeskripsi: TextView = findViewById(R.id.tv_set_overview)


        val tName = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getStringExtra(EXTRA_POTO)
        val tDesk = intent.getStringExtra(EXTRA_DESKRIPSI)
        val tKec = intent.getStringExtra(EXTRA_KECAMATAN)
        val tTah = intent.getStringExtra(EXTRA_TAHUN)


        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)

        tvSetSubDetail1.text = tKec
        tvSetDeskripsi.text = tDesk


    }

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_POTO = "extra_poto"
        const val EXTRA_DESKRIPSI = "extra_deskripsi"
        const val EXTRA_KECAMATAN = "extra_kecamatan"
        const val EXTRA_TAHUN = "extra_tahun"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}