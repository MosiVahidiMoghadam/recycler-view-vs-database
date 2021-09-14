package com.example.myapplication.DBase

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.temp_item_list.view.*

class adapDB(private val data :List<dataDB>): BaseAdapter() {

    override fun getCount(): Int =data.count()

    override fun getItem(position: Int): dataDB =data[position]

    override fun getItemId(position: Int): Long =0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view:View
        val holder:ViewHolder
        if(convertView == null){
            view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main_db,null)
            holder = ViewHolder()
            holder.title = view.findViewById(R.id.txtTitle)
            holder.desc = view.findViewById(R.id.txtDesc)
            view.tag = holder

        }else{

            holder = convertView.tag as ViewHolder
            view = convertView

        }
        val data1 = getItem(position)
        holder.title?.text =data1.title
        holder.desc?.text =data1.Desc
        view.imgEdit.setOnClickListener {

            val intent = Intent(parent.context,Main2Activity::class.java)
            intent.putExtra("ID",data1.ID)
            intent.putExtra("Title",data1.title)
            intent.putExtra("Desc",data1.Desc)
            parent.context.startActivity(intent)

        }

        view.ImgDel.setOnClickListener {
            val db = ManageDBase(parent.context)
            db.delete("ID=?", arrayOf(data1.ID.toString()))
            parent.context.startActivity(Intent(parent.context,Main3Activity::class.java))
        }

        return view
    }
}
class ViewHolder(){
    var title :TextView? = null
    var desc :TextView? = null
}