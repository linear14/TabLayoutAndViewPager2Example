package com.dongldh.tabandviewpager2ex.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context): SQLiteOpenHelper(context, "db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val t_book_create = "create table t_book " +
                "(_id integer primary key autoincrement, title, author, published)"

        db?.execSQL(t_book_create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table t_book")
        onCreate(db)
    }
}