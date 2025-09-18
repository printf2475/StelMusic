package com.template.core.domain

import com.template.core.data.repository.TestTemplateRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

@HiltAndroidTest
class UseCaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var testTemplateRepository: TestTemplateRepository

    @Before
    fun init() {
        hiltRule.inject()
    }




}