package iqro.mobile.randomnumbermvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *Created by Zohidjon Akbarov
 */
class RandomNumberViewModel() : ViewModel() {

    private val model = RandomNumberModel()
    private val _flow = MutableSharedFlow<RandomNumberResponse>()
    val flow: Flow<RandomNumberResponse> get() = _flow

    fun getRandomNumber() {
        viewModelScope.launch {
            model.getRandomNumber().collectLatest {
                _flow.emit(it)
            }
        }
    }

}