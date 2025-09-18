package com.template.feature.home.navigate

import androidx.lifecycle.ViewModel
import com.template.core.domain.usecase.GetTemplateListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTemplateListUseCase: GetTemplateListUseCase
) : ViewModel(), ContainerHost<HomeContract.UiState, HomeContract.SideEffect> {

    override val container = container<HomeContract.UiState, HomeContract.SideEffect>(
        initialState = HomeContract.UiState()
    )

    fun getTemplateList() = intent {
        getTemplateListUseCase()
            .catch {  }
            .collectLatest {

            }
    }

}