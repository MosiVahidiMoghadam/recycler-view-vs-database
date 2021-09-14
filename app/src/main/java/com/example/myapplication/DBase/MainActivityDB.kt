package com.example.myapplication.DBase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import com.example.myapplication.R

class MainActivityDB : AppCompatActivity() {
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_db)

    }

    override fun onResume() {
        super.onResume()
        loadData("%")

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_men,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_new_note)
            startActivity(Intent(this,Main2Activity::class.java))

        return super.onOptionsItemSelected(item)
    }

    fun loadData(title:String){
        val list =  arrayListOf<dataDB>()
        val db = ManageDBase(this)
        val column = arrayOf("ID","Title","Description")
        val selectionArgs= arrayOf(title)
        val result=db.runQuery(column,"Tutle Like?",selectionArgs,"ID")
        if(result.moveToFirst()){
            do {
                val id = result.getInt(result.getColumnIndex("ID"))
                val title2 = result.getString(result.getColumnIndex("Title"))
                val desc = result.getString(result.getColumnIndex("Description"))
                list.add(dataDB(id,title2,desc))
            }while (result.moveToNext())
        }
        val adapterTest =adapDB(list)
        listView = findViewById(R.id.listDB)
        listView.adapter = adapterTest

    }
}