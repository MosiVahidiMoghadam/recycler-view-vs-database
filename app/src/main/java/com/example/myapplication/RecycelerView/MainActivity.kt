package com.example.myapplication.RecycelerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    val data = listOf(
        dataclass(R.drawable.b,"aks1"),
        dataclass(R.drawable.m,"aks2"),
        dataclass(R.drawable.b,"aks3"),
        dataclass(R.drawable.m,"aks4"),
        dataclass(R.drawable.b,"aks5"),
        dataclass(R.drawable.m,"aks6"),
        dataclass(R.drawable.b,"aks7"),
        dataclass(R.drawable.m,"aks8"),
        dataclass(R.drawable.b,"aks9"),
        dataclass(R.drawable.m,"aksA"),
        dataclass(R.drawable.b,"aksB"),
        dataclass(R.drawable.m,"aksC"),
        dataclass(R.drawable.b,"aks1"),
        dataclass(R.drawable.m,"aks2"),
        dataclass(R.drawable.b,"aks3"),
        dataclass(R.drawable.m,"aks4"),
        dataclass(R.drawable.b,"aks5"),
        dataclass(R.drawable.m,"aks6"),
        dataclass(R.drawable.b,"aks7"),
        dataclass(R.drawable.m,"aks8"),
        dataclass(R.drawable.b,"aks9"),
        dataclass(R.drawable.m,"aksA"),
        dataclass(R.drawable.b,"aksB"),
        dataclass(R.drawable.m,"aksC")

    )
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adap = adapterRec(data,this)
        recyclerView.adapter = adap

    }
}