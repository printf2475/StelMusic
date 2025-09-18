package com.template.core.domain.usecase

import com.template.core.data.repository.TemplateRepository
import javax.inject.Inject

class GetTemplateListUseCase @Inject constructor(
    private val templateRepository: TemplateRepository
) {
    operator fun invoke() = templateRepository.getAllTemplate()
}