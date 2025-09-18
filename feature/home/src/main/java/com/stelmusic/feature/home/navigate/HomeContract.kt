package com.stelmusic.feature.home.navigate

object HomeContract {
    sealed class SideEffect {
        data class ShowToast(val message: String) : SideEffect()
    }

    data class UiState(
        val isLoading: Boolean = true
    )
}