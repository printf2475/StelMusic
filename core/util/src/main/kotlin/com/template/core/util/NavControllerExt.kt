package com.template.core.util

import android.annotation.SuppressLint
import androidx.navigation.NavController
import androidx.navigation.serialization.generateHashCode
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@SuppressLint("RestrictedApi")
@OptIn(InternalSerializationApi::class)
fun NavController.findPreviousBackStack(route: KClass<*>): Boolean {
    return this.previousBackStackEntry?.destination?.id == route.serializer().generateHashCode()
}