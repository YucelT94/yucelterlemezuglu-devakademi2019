package com.yucelt.devakademi2019.base.devcomponent

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
abstract class DevComponentView<DB : ViewDataBinding, VM : DevComponentViewModel<*>>(
    context: Context,
    attributeSet: AttributeSet? = null,
    int: Int = 0
) : ConstraintLayout(context, attributeSet, int) {
    var dataBinding: DB? = null
    var viewModel: VM? = null

    init {
        this.init(context)
    }

    private fun init(context: Context) {
        if (this.isInEditMode) {
            View.inflate(context, this.provideLayoutId(), this)
        } else {
            this.viewModel = this.provideViewModel()
            this.dataBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                this.provideLayoutId(),
                this,
                true
            )
            this.bindViewModel(this.dataBinding)
        }
    }

    abstract fun provideViewModel(): VM

    abstract fun bindViewModel(binding: DB?)

    abstract fun provideLayoutId(): Int
}