package com.flesh.paginquestion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class ListViewModel : ViewModel() {
    fun reload() {

    }

    val dataFlow = Pager( // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 10)
    ) {
        ListDataMediator(DummyData())
    }.flow.cachedIn(viewModelScope)

}