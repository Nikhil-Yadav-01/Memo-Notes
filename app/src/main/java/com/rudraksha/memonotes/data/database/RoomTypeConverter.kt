package com.rudraksha.memonotes.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rudraksha.memonotes.data.model.NoteCheckListItem

class RoomTypeConverter {

	@TypeConverter
	fun fromListItemToString(list: List<NoteCheckListItem>): String = Gson().toJson(list)

	@TypeConverter
	fun fromStringToListItem(json: String): List<NoteCheckListItem>{

		val listType = object : TypeToken<List<NoteCheckListItem>>(){}.type

		return Gson().fromJson(json, listType)

	}
}