package com.yucelt.devakademi2019.component.advertisementitem

import android.view.View
import androidx.annotation.ColorRes
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.yucelt.devakademi2019.R
import com.yucelt.devakademi2019.base.devcomponent.DevComponentViewModel
import java.math.RoundingMode
import java.text.DecimalFormat


/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
class AdvertisementItemViewModel : DevComponentViewModel<AdvertisementItemViewData>() {

    val titleObservable = ObservableField<String>()
    val locationObservable = ObservableField<String>()
    val priceObservable = ObservableField<String>()
    val descriptionObservable = ObservableField<String>()
    val viewCountObservable = ObservableField<String>()
    val detailViewVisibilityObservable = ObservableInt(View.GONE)
    val colorObservable = ObservableInt(R.color.white)

    override fun handleInput(viewData: AdvertisementItemViewData?) {
        viewData?.run {
            titleObservable.set(title)
            locationObservable.set("$town/$city")
            priceObservable.set("${priceFormatter(price)} TL")
            descriptionObservable.set(description)
            viewCountObservable.set("$viewCount Görüntülenme")
            category0?.let { getStatusColor(it) }?.let { colorObservable.set(it) }
        }
    }

    /**
     * setItem expand or collapse
     */
    fun expandOrCollapse(expanded: Boolean) {
        if (expanded) detailViewVisibilityObservable.set(View.VISIBLE)
        else detailViewVisibilityObservable.set(View.GONE)
    }

    @ColorRes
    private fun getStatusColor(productState: String): Int {
        return when {
            productState.contains("Emlak") -> R.color.color_emlak
            productState.contains("Vasıta") -> R.color.color_vasita
            productState.contains("Yedek Parça") -> R.color.color_yedek_parca
            productState.contains("İkinci El") -> R.color.color_ikinci_el
            productState.contains("İş Makineleri") -> R.color.color_is_makineleri
            productState.contains("Ustalar") -> R.color.color_ustalar
            productState.contains("Özel") -> R.color.color_ozel_ders
            productState.contains("İş İlanları") -> R.color.color_is_ilanlari
            productState.contains("Yardımcı") -> R.color.color_yardimci
            productState.contains("Hayvanlar") -> R.color.color_hayvanlar
            else -> R.color.white
        }
    }

    /**
     * Format for numbers
     */
    private fun priceFormatter(price: Double?): String {
        val decimalFormat = DecimalFormat("#,###.00")
        decimalFormat.roundingMode = RoundingMode.CEILING

        return decimalFormat.format(price)
    }
}