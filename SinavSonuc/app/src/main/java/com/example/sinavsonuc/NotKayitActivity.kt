package com.example.sinavsonuc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_not_kayit.*

class NotKayitActivity : AppCompatActivity() {

    private lateinit var vt: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_kayit)

        vt = VeritabaniYardimcisi(this)

        toolbarNotKayit.title = "Not kayıt"
        setSupportActionBar(toolbarNotKayit)

        buttonKaydet.setOnClickListener {

            val ders_adi = editTextTextDers.text.toString().trim()
            val not_1 = editTextTextVize.text.toString().trim()
            val not_2 = editTextFinal.text.toString().trim()

            if(TextUtils.isEmpty(ders_adi))
            {
                Snackbar.make(toolbarNotKayit,"Ders adı giriniz : ",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(not_1))
            {
                Snackbar.make(toolbarNotKayit,"1. notu giriniz : ",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(not_2))
            {
                Snackbar.make(toolbarNotKayit,"2. notu giriniz : ",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Notlardao().notEkle(vt,ders_adi,not_1.toInt(),not_2.toInt())

            val intent = Intent(this@NotKayitActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}