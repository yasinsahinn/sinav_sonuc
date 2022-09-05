package com.example.sinavsonuc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class NotlarAdapter(private val mContext: Context,private val notlarList : List<Notlar>)
    :RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim)
    {
        var not_card : CardView
        var textViewDers: TextView
        var textViewVize : TextView
        var textViewFinal : TextView

        init {
            not_card = tasarim.findViewById(R.id.not_card)
            textViewDers = tasarim.findViewById(R.id.textViewDers)
            textViewVize = tasarim.findViewById(R.id.textViewVize)
            textViewFinal = tasarim.findViewById(R.id.textViewFinal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int)
    {
        val not = notlarList.get(position)

        holder.textViewDers.text = not.ders_adi
        holder.textViewVize.text = not.not_1.toString()
        holder.textViewFinal.text = not.not_2.toString()

        holder.not_card.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("nesne",not)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notlarList.size
    }


}