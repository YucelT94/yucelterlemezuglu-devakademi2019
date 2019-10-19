package com.yucelt.devakademi2019.feature.advertisement.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.yucelt.devakademi2019.R
import com.yucelt.devakademi2019.databinding.ActivityAdvertisementBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
class AdvertisementActivity : DaggerAppCompatActivity() {


    private lateinit var binding: ActivityAdvertisementBinding
    private var adapter: AdvertisementListAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: AdvertisementViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(AdvertisementViewModel::class.java)
    }

    companion object {
        private val TAG = AdvertisementActivity::class.java.name
        private val START_POSITION = 1
        private val NUMBER_OF_ITEMS = 50

        /**
         * Activity geçişi için intent oluşturma fonksiyonu
         */
        fun newIntent(context: Context) = Intent(context, AdvertisementActivity::class.java)
    }

    private val paginationController = object : PaginationController() {
        override fun onLoadMore() {
            viewModel.run {
                // progressBarVisibilityObservable.set(View.VISIBLE)
                updateAdapterData(viewModel.adapterDataSize.get() + 1, NUMBER_OF_ITEMS)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        adapter = AdvertisementListAdapter()

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this, R.drawable.item_divider)
            ?.let { divider.setDrawable(it) }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_advertisement)

        binding.run {
            advertisementList.addOnScrollListener(paginationController)
            advertisementList.adapter = adapter
            advertisementList.addItemDecoration(divider)
        }
    }

    private fun observeViewModel() {
        viewModel.adapterLiveData.observe(this@AdvertisementActivity, Observer {
            adapter?.run {
                addData(it)
                itemCount.let { it1 -> viewModel.adapterDataSize.set(it1) }
            }
        })

        viewModel.updateAdapterData(START_POSITION, NUMBER_OF_ITEMS)
    }

    override fun onBackPressed() {}
}