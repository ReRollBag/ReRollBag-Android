package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.domain.usecase.GetUserRentingBagsListUseCase
import com.mediaproject.domain.usecase.GetUserReturnedBagsListUseCase
import com.mediaproject.domain.usecase.GetUserReturningBagsListUseCase
import com.mediaproject.presentation.widgets.states.RentListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RentListViewModel
@Inject
constructor(
    private val getUserRentingBagsListUseCase: GetUserRentingBagsListUseCase,
    private val getUserReturningBagsListUseCase: GetUserReturningBagsListUseCase,
    private val getUserReturnedBagsListUseCase: GetUserReturnedBagsListUseCase
) : ViewModel() {

    private val _listState = MutableLiveData<RentListState>(RentListState.Init)
    val listState: LiveData<RentListState>
        get() = _listState

    fun getListData(
        kind: String
    ) = viewModelScope.launch {
        _listState.postValue(
            RentListState.Update(
                fetchList = when (kind) {
                    "전체" -> sideEffectAllData()
                    "반납" -> sideEffectReturnedData()
                    "대여중" -> sideEffectRentingAndReturningData()
                    else -> listOf()
                }
            )
        )
    }

    private suspend fun sideEffectAllData(): List<BagInfo> = withContext(Dispatchers.IO) {
        val map = hashMapOf<String, BagInfo>()
        getUserRentingBagsListUseCase().onSuccess { list ->
            list.forEach {
                map[it.bagsId] = it
            }
        }
        getUserReturningBagsListUseCase().onSuccess { list ->
            list.forEach {
                map[it.bagsId] = it
            }
        }
        getUserReturnedBagsListUseCase().onSuccess { list ->
            list.forEach {
                map[it.bagsId] = it
            }
        }
        return@withContext map.values.toList()
    }

    private suspend fun sideEffectReturnedData(): List<BagInfo> = withContext(Dispatchers.IO) {
        val map = hashMapOf<String, BagInfo>()
        getUserReturnedBagsListUseCase().onSuccess { list ->
            list.forEach {
                map[it.bagsId] = it
            }
        }
        return@withContext map.values.toList()
    }

    private suspend fun sideEffectRentingAndReturningData() = withContext(Dispatchers.IO) {
        val map = hashMapOf<String, BagInfo>()
        getUserRentingBagsListUseCase().onSuccess { list ->
            list.forEach {
                map[it.bagsId] = it
            }
        }
        getUserReturningBagsListUseCase().onSuccess { list ->
            list.forEach {
                map[it.bagsId] = it
            }
        }
        return@withContext map.values.toList()
    }
}