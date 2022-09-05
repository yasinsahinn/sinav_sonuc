package com.example.sinavsonuc

import android.content.ContentValues

class Notlardao
{
    fun tumNotlar(vt:VeritabaniYardimcisi): ArrayList<Notlar>
    {
        val db = vt.writableDatabase
        val notlarList = ArrayList<Notlar>()
        val cursor = db.rawQuery("SELECT * FROM notlar",null)

        while (cursor.moveToNext())
        {
           val not =  Notlar(cursor.getInt(cursor.getColumnIndex("not_id"))
               ,cursor.getString(cursor.getColumnIndex("ders_adi"))
               ,cursor.getInt(cursor.getColumnIndex("not_1"))
               ,cursor.getInt(cursor.getColumnIndex("not_2")))

            notlarList.add(not)
        }
        return notlarList
    }

    fun notSil(vt:VeritabaniYardimcisi, not_id: String)
    {
        val db = vt.writableDatabase
        db.delete("notlar","not_id=?", arrayOf(not_id.toString()))
    }

    fun notEkle(vt:VeritabaniYardimcisi,ders_adi:String,not_1:Int,not_2:Int)
    {
        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("ders_adi",ders_adi)
        values.put("not_1",not_1)
        values.put("not_2",not_2)

        db.insertOrThrow("notlar",null,values)
        db.close()
    }

    fun notGuncelle(vt:VeritabaniYardimcisi, not_id: Int, ders_adi:String, not_1:Int, not_2:Int)
    {
        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("ders_adi",ders_adi)
        values.put("not_1",not_1)
        values.put("not_2",not_2)

        db.update("notlar",values,"not_id=?", arrayOf(not_id.toString()))
        db.close()
    }
}