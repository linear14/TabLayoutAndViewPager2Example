package com.dongldh.tabandviewpager2ex.data

import android.content.ContentValues
import android.content.Context
import android.widget.Toast

class BookDao(private val context: Context) {
    val helper = Database(context)

    fun selectAll(): MutableList<Book> {
        val db = helper.writableDatabase
        val list = mutableListOf<Book>()
        val cursor = db.rawQuery("select * from t_book", null)

        while(cursor.moveToNext()) {
            list.add(Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)))
        }
        db.close()
        return list
    }

    fun insertBook(book: Book) {
        val db = helper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("title", book.title)
        contentValues.put("author", book.author)
        contentValues.put("published", book.published)
        db.insert("t_book", null, contentValues)
        db.close()

        Toast.makeText(context, "도서 등록 완료", Toast.LENGTH_SHORT).show()
    }
}