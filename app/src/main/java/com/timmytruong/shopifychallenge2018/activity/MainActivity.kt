package com.timmytruong.shopifychallenge2018.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.timmytruong.shopifychallenge2018.*
import com.timmytruong.shopifychallenge2018.adapter.ViewPagerAdapter
import com.timmytruong.shopifychallenge2018.dagger.component.DaggerAppComponent
import com.timmytruong.shopifychallenge2018.fragment.ProvinceFragment
import com.timmytruong.shopifychallenge2018.fragment.YearFragment
import com.timmytruong.shopifychallenge2018.interfaces.ItemClickedListener
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import com.timmytruong.shopifychallenge2018.util.CommonUtils
import com.timmytruong.shopifychallenge2018.viewmodel.OrderViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity()
{
    @Inject lateinit var orderViewModel: OrderViewModel

    private lateinit var provinceFragmentTitle: String

    private lateinit var yearFragmentTitle: String

    private lateinit var pageAdapter: ViewPagerAdapter

    private val tabsFragment: ArrayList<Fragment> = arrayListOf()

    private val tabsTitles: ArrayList<String> = arrayListOf()

    private val itemClickedListener =
        object: ItemClickedListener
        {
            override fun openDetailsActivity(item: ProvinceOrderItem)
            {
                val intent = Intent(this@MainActivity, OrderDetailsActivity::class.java)

                intent.putExtra(AppConstants.ITEM_INTENT_KEY, item)

                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.create().inject(this)

        setContentView(R.layout.activity_main)

        loadResources()

        loadFragments()

        loadTitles()

        setupViewPager()

        CommonUtils.loadResources(applicationContext)

        orderViewModel.getOrderData()
    }

    private fun setupViewPager()
    {
        pageAdapter = ViewPagerAdapter(supportFragmentManager = supportFragmentManager, fragments = tabsFragment, titles = tabsTitles)

        view_pager.adapter = pageAdapter

        tab_layout.setupWithViewPager(view_pager)
    }

    private fun loadFragments()
    {
        val provinceFragment = ProvinceFragment(orderViewModel, itemClickedListener)

        val yearFragment = YearFragment(orderViewModel, itemClickedListener)

        tabsFragment.add(provinceFragment)

        tabsFragment.add(yearFragment)
    }

    private fun loadTitles()
    {
        tabsTitles.add(AppConstants.PROVINCE_FRAGMENT_TAG)

        tabsTitles.add(AppConstants.YEAR_FRAGMENT_TAG)
    }

    private fun loadResources()
    {
        provinceFragmentTitle = resources.getString(R.string.tabs_order_province)

        yearFragmentTitle = resources.getString(R.string.tabs_order_year)
    }
}
