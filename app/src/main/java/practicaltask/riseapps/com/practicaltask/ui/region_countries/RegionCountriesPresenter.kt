package practicaltask.riseapps.com.practicaltask.ui.region_countries

import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import practicaltask.riseapps.com.practicaltask.R.id.pbProcessing
import practicaltask.riseapps.com.practicaltask.network.CountriesApi
import practicaltask.riseapps.com.practicaltask.network.model.CountryData
import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter
import java.util.*

class RegionCountriesPresenter : BasePresenter<RegionCountriesView>() {
    private val countriesList: ArrayList<CountryData> = ArrayList()
    private val countriesApi by lazy {
        CountriesApi.create()
    }

    fun loadCountriesDataByRegion(regionName: String) {
        countriesApi.getCountriesByRegion(regionName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            fillCountriesList(result)
                            view!!.fillRecyclerByCountriesData(countriesList)
                        },
                        {
                            view!!.hideProgress()
                        }
                )
    }

    private fun fillCountriesList(countriesResultList: List<CountryData>) {
        countriesList.addAll(countriesResultList)
    }
}