package practicaltask.riseapps.com.practicaltask.network.model

import com.google.gson.annotations.SerializedName

data class CountryData(
        @SerializedName("name") val name: String,
        @SerializedName("topLevelDomain") val topLevelDomain: List<String>,
        @SerializedName("alpha2Code") val alpha2Code: String,
        @SerializedName("alpha3Code") val alpha3Code: String,
        @SerializedName("capital") val capital: String,
        @SerializedName("altSpellings") val altSpellings: List<String>,
        @SerializedName("subregion") val subregion: String,
        @SerializedName("population") val population: Int,
        @SerializedName("latlng") val latlng: List<Double>,
        @SerializedName("area") val area: Int,
        @SerializedName("gini") val gini: Double,
        @SerializedName("numericCode") val numericCode: Int
)