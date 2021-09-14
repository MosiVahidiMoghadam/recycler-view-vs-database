package com.example.myapplication.DBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast

class ManageDBase(context:Context) {

    private val DBName = "notesDB"
    private val tableName = "tblNotes"
    private val colID ="ID"
    private val colTitle = "Title"
    private val colDesc = "Description"
    private val dbVersion = 1
    private val sqlCreatTable = "CREATE TABLE IF NOT EXISTS $tableName ($colID INTEGER PRIMARY KEY,$colTitle VARCHAR,$colDesc TEXT);"
    private val db = DataBaseHelper(context)
    private val sqlDB = db.writableDatabase
    inner class DataBaseHelper(private val context2: Context):SQLiteOpenHelper(context2,DBName,null,dbVersion){
        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL(sqlCreatTable)
            Toast.makeText(context2,"creat db",Toast.LENGTH_SHORT).show()
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS $tableName")
        }

    }

    fun insert(values: ContentValues):Long = sqlDB.insert(tableName,"",values)

    fun runQuery(columns : Array<String>,selection:String , selectionArgs:Array<String>,sortOrder:String):Cursor{

        val db = SQLiteQueryBuilder()
        db.tables = tableName
        return db.query(sqlDB,columns,selection,selectionArgs,null,null,sortOrder)
    }

    fun delete(selection : String , selectionArgs : Array<String>):Int = sqlDB.delete(tableName,selection,selectionArgs)

    fun update(values: ContentValues,selection: String,selectionArgs: Array<String>):Int = sqlDB.update(tableName,values,selection,selectionArgs)



}