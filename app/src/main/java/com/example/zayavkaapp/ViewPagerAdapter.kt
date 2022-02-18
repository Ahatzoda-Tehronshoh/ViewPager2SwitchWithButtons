package com.example.zayavkaapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when(position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()
        }

}