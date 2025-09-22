package com.rudraksha.memonotes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rudraksha.memonotes.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(RoomTypeConverter::class)
abstract class NotesDatabase: RoomDatabase(){

	abstract fun noteDao(): NoteDao

	companion object{

		@Volatile
		private var INSTANCE: NotesDatabase? = null

		fun getDataBase(context: Context): NotesDatabase {

			return INSTANCE ?: synchronized(this){
				Room.databaseBuilder(
					context = context,
					klass = NotesDatabase::class.java,
					name = "notes_database"
				)
					.fallbackToDestructiveMigration(true)
					.build()
					.also { INSTANCE = it }

			}
		}
	}

}