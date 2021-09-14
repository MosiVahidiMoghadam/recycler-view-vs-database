package com.example.myapplication.RealmDB

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.R
import io.realm.Realm

class RealmActivity : AppCompatActivity() {
    private val realmDB = UserDAO()
    lateinit var firstRun :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        firstRun = getSharedPreferences("firstRun", Context.MODE_PRIVATE)


    }
    fun onClick(view:View){
        when(view.id){

            R.id.btn_crt ->{

                if (firstRun.getBoolean("first_run",true)){

                for(i in 0..9) {

                    val objectUser = ObjectUser()
//                    objectUser.id = i + 1
                    objectUser.name = "name${i + 1}"
                    objectUser.family = "family${i + 1}"
                    realmDB.insertDB(objectUser)
                }
                    val editor =firstRun.edit()
                    editor.putBoolean("first_run",false)
                    editor.apply()
                }else{
                    Log.i("REALM_TAG","it was Creat")
                }
        }

            R.id.btn_rda ->{
                try {

                    val result = realmDB.readAll()
                    for (i in result)
                        Log.i("REALM_TAG","${i.id}")
                }catch (ex:Exception){
                    ex.printStackTrace()
                }
            }

            R.id.btn_rdbi ->{
                try {
                    val resultBI = realmDB.readById(5)
                    Log.i("REALM_TAG","${resultBI?.name}${resultBI?.family}")
                }catch (ex:Exception){
                    ex.printStackTrace()
                }

            }

            R.id.btn_dela -> realmDB.deleteAll()

            R.id.btn_delbi -> realmDB.deleteById(5)

            R.id.btn_update ->{
                val objectUser  = ObjectUser()
                objectUser.id = 5
                objectUser.name = "name-6-update"
                objectUser.family = "family-6-update"
                realmDB.insertDB(objectUser)
            }
        }


    }

    override fun onDestroy() {
        realmDB.closeDB()
        super.onDestroy()
    }
}