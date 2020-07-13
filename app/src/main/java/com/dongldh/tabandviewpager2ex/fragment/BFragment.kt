package com.dongldh.tabandviewpager2ex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.dongldh.tabandviewpager2ex.R
import com.dongldh.tabandviewpager2ex.adapter.FragmentBAdapter
import com.dongldh.tabandviewpager2ex.data.Book
import com.dongldh.tabandviewpager2ex.data.BookDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_b.view.*

class BFragment: Fragment() {
    var bookList = mutableListOf<Book>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        val pageMarginPixel = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pagerWidth)
        val screenWidth = resources.displayMetrics.widthPixels
        val offsetPixel = screenWidth - pagerWidth - pageMarginPixel

        bookList = BookDao(this.requireContext()).selectAll()
        view.recyclerViewPager2.adapter = FragmentBAdapter(bookList)
        view.recyclerViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        view.recyclerViewPager2.offscreenPageLimit = 1
        view.recyclerViewPager2.setPageTransformer { page, position -> page.translationX = position * (-offsetPixel) }

        activity?.viewPager2?.requestDisallowInterceptTouchEvent(true)

        return view
    }
}