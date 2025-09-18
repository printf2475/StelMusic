package com.stelmusic.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stelmusic.core.database.dao.TemplateDao
import com.stelmusic.core.database.model.TemplateEntity

@Database(
    entities = [TemplateEntity::class],
    version = 1
)
internal abstract class TemplateDataBase : RoomDatabase() {
    abstract fun templateDao(): TemplateDao
}