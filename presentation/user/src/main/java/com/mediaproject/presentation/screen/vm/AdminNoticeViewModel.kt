package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediaproject.domain.usecase.SaveNoticeWithTitleAndContentUseCase
import com.mediaproject.presentation.widgets.states.AdminNoticeState
import com.mediaproject.presentation.widgets.states.RentMarkerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminNoticeViewModel
@Inject
constructor(
    private val saveNoticeWithTitleAndContentUseCase: SaveNoticeWithTitleAndContentUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<AdminNoticeState>(AdminNoticeState.Init)
    val state: LiveData<AdminNoticeState>
        get() = _state

    fun saveNotice() {
        when (val value = _state.value) {
            is AdminNoticeState.Update -> CoroutineScope(Dispatchers.IO).launch {
                saveNoticeWithTitleAndContentUseCase(
                    params = SaveNoticeWithTitleAndContentUseCase.Params(
                        title = value.title,
                        content = value.content
                    )
                ).onSuccess {
                    _state.postValue(AdminNoticeState.Success)
                }
            }
            else -> {}
        }
    }

    fun onChangeTitle(title: String) {
        when (val value = _state.value) {
            is AdminNoticeState.Update -> _state.value = AdminNoticeState.Update(
                title = title,
                content = value.content
            )
            else -> _state.value = AdminNoticeState.Update(
                title = title,
                content = ""
            )
        }
    }

    fun onChangeContent(content: String) {
        when (val value = _state.value) {
            is AdminNoticeState.Update -> _state.value = AdminNoticeState.Update(
                title = value.title,
                content = content
            )
            else -> _state.value = AdminNoticeState.Update(
                title = "",
                content = content
            )
        }
    }

}