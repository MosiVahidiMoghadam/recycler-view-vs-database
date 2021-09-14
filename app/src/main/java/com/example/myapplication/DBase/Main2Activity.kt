package com.example.myapplication.DBase

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var id = -1
        if (intent.extras != null){

            id = intent.getIntExtra("ID",-1)
            editTitle.setText(intent.getStringExtra("Title"))
            editDesc.setText(intent.getStringExtra("Desc"))
        }
        btnAdd.setOnClickListener {

            if (editTitle.text.toString() == "" || editDesc.text.toString() == ""){
                Toast.makeText(this,"some field is empty",Toast.LENGTH_SHORT).show()
            }else{
                val db= ManageDBase(this)
                val values = ContentValues()
                values.put("Title",editTitle.text.toString())
                values.put("Desc",editDesc.text.toString())
                if (id == -1){

                    val result = db.insert(values)
                    if (result > 0)
                        Toast.makeText(this,"note saved",Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this,"problem in saved note",Toast.LENGTH_SHORT).show()

                }else{

                    val result = db.update(values,"ID=?", arrayOf(id.toString()))
                    id = -1
                    if (result > 0)
                        Toast.makeText(this,"update note",Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this,"problem in update note",Toast.LENGTH_SHORT).show()

                }
            }

        }
    }
}