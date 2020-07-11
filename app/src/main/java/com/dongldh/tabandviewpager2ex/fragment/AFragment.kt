package com.dongldh.tabandviewpager2ex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dongldh.tabandviewpager2ex.R
import com.dongldh.tabandviewpager2ex.data.Book
import com.dongldh.tabandviewpager2ex.data.BookDao
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*
import kotlinx.android.synthetic.main.fragment_a.view.title_input

class AFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        view.enroll_book_button.setOnClickListener {
            BookDao(this.requireContext()).insertBook(Book(-1, title_input.text.toString(), author_input.text.toString(), published_input.text.toString()))
        }
        return view
    }
}