package com.example.myapplication.RecycelerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class adapterRec(val data :List<dataclass>, val cont:Context):RecyclerView.Adapter<adapterRec.VHolder>() {
    lateinit var linearLayout: LinearLayout
    inner class VHolder(item:View):RecyclerView.ViewHolder(item){
        val text = item.findViewById<TextView>(R.id.txtRec)
        val image = item.findViewById<ImageView>(R.id.imgRec)


        init {
            linearLayout = item.findViewById(R.id.linId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
     return VHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_for_receycler,parent,false))
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {

        holder.image.setImageResource(data[position].img)
        holder.text.text = data[position].txt
        linearLayout.setOnClickListener {
            Toast.makeText(cont,"${data[position].txt}",Toast.LENGTH_SHORT).show()

        }

    }



    override fun getItemCount(): Int = data.size
}