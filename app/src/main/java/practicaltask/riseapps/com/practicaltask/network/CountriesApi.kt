package practicaltask.riseapps.com.practicaltask.network

import io.reactivex.Single
import practicaltask.riseapps.com.practicaltask.BuildConfig
import practicaltask.riseapps.com.practicaltask.network.model.CountryData
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {
    @GET("region/{region}")
    fun getCountriesByRegion(@Path("region") region: String): Single<List<CountryData>>

    companion object {
        fun create(): CountriesApi {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build()

            return retrofit.create(CountriesApi::class.java)
        }
    }
}