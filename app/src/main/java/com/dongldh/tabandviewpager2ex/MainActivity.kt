package com.dongldh.tabandviewpager2ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dongldh.tabandviewpager2ex.adapter.MainFragmentAdapter
import com.dongldh.tabandviewpager2ex.fragment.AFragment
import com.dongldh.tabandviewpager2ex.fragment.BFragment
import com.dongldh.tabandviewpager2ex.fragment.CFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // var fragmentSelected: Fragment = AFragment()
    val tabLayoutTextArray = arrayOf("Tab A", "Tab B", "Tab C")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // supportFragmentManager.beginTransaction().replace(R.id.fragment, fragmentSelected).commit()

        viewPager2.adapter = MainFragmentAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager2) { tab: TabLayout.Tab, position: Int ->
            tab.text = tabLayoutTextArray[position]
        }.attach()

        /*
        // tabLayout만을 사용할 경우 아래와 같이 작업

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Reselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "FirstSelected", Toast.LENGTH_SHORT).show()
                when(tab?.position) {
                    0 -> fragmentSelected = AFragment()
                    1 -> fragmentSelected = BFragment()
                    2 -> fragmentSelected = CFragment()
                }
                supportFragmentManager.beginTransaction().replace(R.id.fragment, fragmentSelected).commit()
            }
        })
        */
    }
}