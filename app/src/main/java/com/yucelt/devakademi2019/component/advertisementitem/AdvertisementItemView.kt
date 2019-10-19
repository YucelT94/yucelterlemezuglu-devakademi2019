package com.yucelt.devakademi2019.component.advertisementitem

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import com.yucelt.devakademi2019.R
import com.yucelt.devakademi2019.base.devcomponent.DevComponentView
import com.yucelt.devakademi2019.databinding.ComponentAdvertisementItemBinding

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */

@BindingAdapter("viewData")
fun AdvertisementItemView.setData(viewData: AdvertisementItemViewData?) {
    viewData?.let { viewModel?.handleInput(it) }
}

/**
 * Kullanım şekli:
 *
 * <com.yucelt.devakademi2019.component.advertisementitem.AdvertisementItemView
 *      viewData="@{viewModel.viewDataObservableField}" />
 */
class AdvertisementItemView :
    DevComponentView<ComponentAdvertisementItemBinding, AdvertisementItemViewModel> {


    companion object {
        val LAYOUT_RES_ID = R.layout.component_advertisement_item
    }

    var eventHandler: AdvertisementItemEventHandlerl? = null


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun provideViewModel() = AdvertisementItemViewModel()

    override fun bindViewModel(binding: ComponentAdvertisementItemBinding?) {
        binding?.viewModel = viewModel
        init()
    }

    private fun init() {

    }
}