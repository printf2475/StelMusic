package com.template.core.database

import com.template.core.database.dao.TemplateDao
import com.template.core.database.model.TemplateEntity
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
class TemplateDataBaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Inject
    @Named("test_template_dao")
    lateinit var templateDao: TemplateDao

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun getTemplateListFromDB() = runTest {
        val templateEntityList = listOf(
            TemplateEntity(
                id = "1",
                date = Date().toString()
            ),
            TemplateEntity(
                id = "2",
                date = Date().toString()
            )
        )
        templateDao.upsert(templateEntityList = templateEntityList)

        val savedTemplateList = templateDao.getAll().first()

        assertEquals(templateEntityList, savedTemplateList)
    }
}