package com.example.myapplication.RealmDB

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ObjectUser:RealmObject() {

    @PrimaryKey
    var id: Long? = null

    lateinit var name : String
    lateinit var family : String

}