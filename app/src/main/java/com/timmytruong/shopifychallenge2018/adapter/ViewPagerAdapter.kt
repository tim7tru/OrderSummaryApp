package com.timmytruong.shopifychallenge2018.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val supportFragmentManager: FragmentManager,
                       private val fragments: ArrayList<Fragment>,
                       private val titles: ArrayList<String>): FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{
    override fun getItem(position: Int): Fragment
    {
        return fragments[position]
    }

    override fun getCount(): Int
    {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        when (position)
        {
            0 ->
            {
                return titles[0]
            }
            1 ->
            {
                return titles[1]
            }
        }
        return ""
    }

}