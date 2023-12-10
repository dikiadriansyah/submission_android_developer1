package com.example.myapplication

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.data.Wisata
import com.example.myapplication.data.WisataData

class MainActivity : AppCompatActivity() {

    private lateinit var rvWisata: RecyclerView
    private val list: ArrayList<Wisata> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "Home"

        rvWisata = findViewById(R.id.rv_Wisata)
        rvWisata.setHasFixedSize(true)

        list.addAll(WisataData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvWisata.layoutManager = LinearLayoutManager(this)

        val listWisataAdapter = ListWisataAdapter(list)
        rvWisata.adapter = listWisataAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.m_account->{
                val selectAbout = Intent(this@MainActivity, DetailAkun::class.java)
                startActivity(selectAbout)
            }
        }
    }


}