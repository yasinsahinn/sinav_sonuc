package com.example.sinavsonuc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    private lateinit var not:Notlar
    private lateinit var vt:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        toolbarNotDetay.title = "Not Detay"
        setSupportActionBar(toolbarNotDetay)

        vt = VeritabaniYardimcisi(this)

        not = intent.getSerializableExtra("nesne") as Notlar

        editTextTextDerss.setText(not.ders_adi)
        editTextTextVizee.setText(not.not_1.toString())
        editTextFinall.setText(not.not_2.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.action_sil ->
            {
                Snackbar.make(toolbarNotDetay,"Silinsin mi ? ",Snackbar.LENGTH_SHORT)
                    .setAction("EVET"){

                        Notlardao().notSil(vt, not.not_id.toString())

                        val intent = Intent(this@DetayActivity,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }.show()

                return true
            }
            R.id.action_duzenle ->
            {
                val ders_adi = editTextTextDerss.text.toString().trim()
                val not_1 = editTextTextVizee.text.toString().trim()
                val not_2 = editTextFinall.text.toString().trim()

                if(TextUtils.isEmpty(ders_adi))
                {
                    Snackbar.make(toolbarNotDetay,"Ders adı giriniz : ",Snackbar.LENGTH_SHORT).show()
                    return false
                }

                if(TextUtils.isEmpty(not_1))
                {
                    Snackbar.make(toolbarNotDetay,"1. notu giriniz : ",Snackbar.LENGTH_SHORT).show()
                    return false
                }

                if(TextUtils.isEmpty(not_2))
                {
                    Snackbar.make(toolbarNotDetay,"2. notu giriniz : ",Snackbar.LENGTH_SHORT).show()
                    return false
                }

                Notlardao().notGuncelle(vt,not.not_id,ders_adi,not_1.toInt(),not_2.toInt())

                val intent = Intent(this@DetayActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return false
        }
    }
}