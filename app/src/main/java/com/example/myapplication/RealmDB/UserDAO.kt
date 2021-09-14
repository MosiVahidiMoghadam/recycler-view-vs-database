package com.example.myapplication.RealmDB

import android.util.Log
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.PrimaryKey
import java.lang.Exception

class UserDAO {

    private  var realm = Realm.getDefaultInstance()
    fun insertDB(tableUser: ObjectUser){
        realm.executeTransaction {
            val currentId =it.where(ObjectUser::class.java).max("id")

            val nextId =
                when{
                    tableUser.id != null -> tableUser.id
                    currentId == null -> 1
                    else -> currentId.toLong() + 1

                }
            tableUser.id = nextId

            it.copyToRealmOrUpdate(tableUser)
        }

    }

    fun readAll():RealmResults<ObjectUser> = realm.where(ObjectUser::class.java).findAll()

    fun readById(id :Int):ObjectUser? =realm.where(ObjectUser::class.java)
        .not()
        .beginGroup()
        .equalTo("name","mosi")
        .equalTo("family","vahidi")
        .endGroup()
        .findFirst()

    fun deleteAll(){

        realm.executeTransaction {

            readAll().deleteAllFromRealm()
        }
    }

    fun deleteById(id:Int){
        realm.executeTransaction {

            try {
                readById(id)?.deleteFromRealm()

            }catch (ex:Exception){
                ex.printStackTrace()
            }

        }

    }
//    fun updateUser(objectUser: ObjectUser){
//
//    }

    fun closeDB(){
        realm.close()
    }

}