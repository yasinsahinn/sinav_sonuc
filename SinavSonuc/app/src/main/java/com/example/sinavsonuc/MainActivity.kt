package com.example.sinavsonuc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notlarList: ArrayList<Notlar>
    private lateinit var adapter : NotlarAdapter

    private lateinit var vt : VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Notlar Uygulaması"
        //toolbar.subtitle = "Ortalama  : 68"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this@MainActivity)

        val

        vt = VeritabaniYardimcisi(this@MainActivity)

        notlarList = Notlardao().tumNotlar(vt)

        adapter = NotlarAdapter(this,notlarList)

        rv.adapter = adapter



        fabBtn.setOnClickListener{

            val intent = Intent(this@MainActivity,NotKayitActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}