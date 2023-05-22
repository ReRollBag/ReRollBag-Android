package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.GetNoticeByLastUpdatedUseCase
import com.mediaproject.domain.usecase.GetNoticeListByAllUseCase
import com.mediaproject.domain.usecase.SaveNoticeWithTitleAndContentUseCase
import com.mediaproject.presentation.widgets.states.NoticeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeViewModel
@Inject
constructor(
    private val saveNoticeWithTitleAndContentUseCase: SaveNoticeWithTitleAndContentUseCase,
    private val getNoticeByLastUpdatedUseCase: GetNoticeByLastUpdatedUseCase,
    private val getNoticeListByAllUseCase: GetNoticeListByAllUseCase,
) : ViewModel() {

    private val _noticeState = MutableLiveData<NoticeState>(NoticeState.Init)
    val noticeState: LiveData<NoticeState>
        get() = _noticeState

    fun getNoticeByLastUpdated() = viewModelScope.launch {
        getNoticeByLastUpdatedUseCase().onSuccess {
            _noticeState.postValue(
                NoticeState.Update(
                    lastUpdatedNotice = it,
                    noticeList = listOf(it)
                )
            )
        }
    }

    fun getNoticeListByAll() = viewModelScope.launch {
        getNoticeListByAllUseCase().onSuccess {
            if (it.isNotEmpty()) {
                _noticeState.postValue(
                    NoticeState.Update(
                        lastUpdatedNotice = it.last(),
                        noticeList = it
                    )
                )
            }
        }
    }

}