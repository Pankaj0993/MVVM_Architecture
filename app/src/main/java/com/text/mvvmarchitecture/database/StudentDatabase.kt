package com.text.mvvmarchitecture.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentEntity::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun getStudent(): StudentDao

    companion object {
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(context: Context): StudentDatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context,
                            StudentDatabase::class.java,
                            "quote_database"
                        )
                            .createFromAsset("quotes.db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}