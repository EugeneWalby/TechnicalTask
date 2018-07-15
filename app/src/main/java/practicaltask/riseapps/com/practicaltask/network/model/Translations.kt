package practicaltask.riseapps.com.practicaltask.network.model

import com.google.gson.annotations.SerializedName

data class Translations (
		@SerializedName("de") val de : String,
		@SerializedName("es") val es : String,
		@SerializedName("fr") val fr : String,
		@SerializedName("ja") val ja : String,
		@SerializedName("it") val it : String,
		@SerializedName("br") val br : String,
		@SerializedName("pt") val pt : String
)