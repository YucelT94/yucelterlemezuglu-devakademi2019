package com.yucelt.devakademi2019.feature.advertisement.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yucelt.devakademi2019.R
import com.yucelt.devakademi2019.component.advertisementitem.AdvertisementItemEventHandler
import com.yucelt.devakademi2019.component.advertisementitem.AdvertisementItemViewData
import com.yucelt.devakademi2019.databinding.RowListItemBinding
import java.util.*

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */

class AdvertisementListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = AdvertisementListAdapter::class.java.name

    private val viewDatas: MutableList<AdvertisementItemViewData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.row_list_item, parent, false
        )
        return AdvertisementItemViewHolder(holderBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? AdvertisementItemViewHolder)?.onBind(getItem(position))
    }

    private fun getItem(position: Int): AdvertisementItemViewData {
        return viewDatas[position]
    }

    override fun getItemCount(): Int {
        return viewDatas.size
    }

    fun addData(list: List<AdvertisementItemViewData>) {
        this.viewDatas.addAll(list)
        notifyDataSetChanged()
    }


    inner class AdvertisementItemViewHolder(private val dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun onBind(viewData: AdvertisementItemViewData) {
            val binding = dataBinding as RowListItemBinding
            binding.item = viewData
        }
    }
}