package com.template.core.data

import com.template.core.data.repository.DefaultTemplateRepository
import com.template.core.data.repository.TemplateRepository
import com.template.core.database.dao.TemplateDao
import com.template.core.model.TemplateModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class TemplateRepositoryTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var repository: TemplateRepository

    @Inject
    @Named("test_template_dao")
    lateinit var templateDao: TemplateDao

    @Before
    fun init() {
        hiltRule.inject()
        repository = DefaultTemplateRepository(templateDao = templateDao)
    }

    @Test
    fun getTemplateModelListFromRepository() = runTest {
        val templateModelList = listOf(
            TemplateModel(
                id = "1",
                date = Date().toString()
            ),
            TemplateModel(
                id = "2",
                date = Date().toString()
            )
        )

        templateModelList.forEach {
            repository.upsertTemplate(it)
        }

        val savedTemplateModelList = repository.getAllTemplate().first()
        println("templateModelList: $templateModelList")
        println("savedTemplateModelList: $savedTemplateModelList")

        assertEquals(templateModelList, savedTemplateModelList)
    }
}