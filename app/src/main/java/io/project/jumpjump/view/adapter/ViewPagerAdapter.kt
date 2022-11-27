package io.project.jumpjump.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragmentList: MutableList<Fragment> = arrayListOf()
    private val titleList: MutableList<String> = arrayListOf()

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    override fun getItemCount(): Int = titleList.size

    fun getTitle(position: Int): String = titleList[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

}