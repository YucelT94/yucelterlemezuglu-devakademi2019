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

        /**
         * Activity geçişi için intent oluşturma fonksiyonu
         */
        fun newIntent(context: Context) = Intent(context, AdvertisementActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = AdvertisementListAdapter()

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this, R.drawable.item_divider)
            ?.let { divider.setDrawable(it) }


        binding = DataBindingUtil.setContentView(this, R.layout.activity_advertisement)
        binding.run {
            advertisementList.adapter = adapter
            advertisementList.addItemDecoration(divider)
        }

        viewModel.adapterLiveData.observe(this@AdvertisementActivity, Observer {
            adapter?.addData(it)
        })

        viewModel.generataAdapterData(1, 20)
    }

    override fun onBackPressed() {}
}