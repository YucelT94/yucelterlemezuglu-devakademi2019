package com.yucelt.devakademi2019.feature.advertisement.presentation

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
abstract class PaginationController : RecyclerView.OnScrollListener() {

    companion object {
        private const val DEFAULT_THRESHOLD = 5
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        val layoutManager = recyclerView.layoutManager
        val visibleItemCount = layoutManager?.childCount ?: 0
        val totalItemCount = layoutManager?.itemCount ?: 0

        var firstVisibleItemPosition = 0
        if (layoutManager is LinearLayoutManager) {
            firstVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
        } else if (layoutManager is GridLayoutManager) {
            firstVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
        }

        if (visibleItemCount + firstVisibleItemPosition + DEFAULT_THRESHOLD >= totalItemCount) {
            onLoadMore()
        }
    }

    /**
     * Load more item
     */
    abstract fun onLoadMore()
}