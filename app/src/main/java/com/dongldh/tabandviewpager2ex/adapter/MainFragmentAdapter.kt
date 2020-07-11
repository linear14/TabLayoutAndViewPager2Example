package com.dongldh.tabandviewpager2ex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dongldh.tabandviewpager2ex.fragment.AFragment
import com.dongldh.tabandviewpager2ex.fragment.BFragment
import com.dongldh.tabandviewpager2ex.fragment.CFragment

class MainFragmentAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifeCycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AFragment()
            1 -> BFragment()
            else -> CFragment()
        }
    }
}