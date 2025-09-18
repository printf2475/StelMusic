package com.template.core.domain.usecase

import com.template.core.data.repository.TemplateRepository
import com.template.core.model.TemplateModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpsertTemplateModelUseCase @Inject constructor(
    private val templateRepository: TemplateRepository
) {
    operator fun invoke(templateModel: TemplateModel) = flow {
        templateRepository.upsertTemplate(templateModel)
        emit(Unit)
    }
}