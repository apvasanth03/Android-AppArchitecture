package com.vasanth.commoncore.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@Suppress("VariableNaming")
abstract class BaseViewModel<STATE, EVENT, SIDEEFECT> : ViewModel() {

    // region Variable Declaration
    protected val _uiState by lazy { MutableStateFlow(initialState) }
    protected val _sideEffect = Channel<SIDEEFECT>(Channel.BUFFERED)

    val uiState: StateFlow<STATE> by lazy { _uiState }
    val sideEffect: Flow<SIDEEFECT> = _sideEffect.receiveAsFlow()
    // endregion

    // region Abstract Members.
    abstract val initialState: STATE

    abstract fun handleEvent(event: EVENT)
    // endregion

    // region Helper Methods
    protected fun sendSideEffect(sideEffect: SIDEEFECT) {
        viewModelScope.launch {
            _sideEffect.send(sideEffect)
        }
    }
    // endregion
}
