package practicaltask.riseapps.com.practicaltask.ui.region_countries

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_region_countries.*
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.core.App
import practicaltask.riseapps.com.practicaltask.network.CountriesApi
import practicaltask.riseapps.com.practicaltask.network.model.CountryData
import practicaltask.riseapps.com.practicaltask.ui.adapter.MenuAdapter
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity

class RegionCountriesActivity : BaseActivity() {
    private val countriesApi by lazy {
        CountriesApi.create()
    }
    private val countriesList: ArrayList<CountryData> = ArrayList()

    override fun provideLayout(): Int {
        return R.layout.activity_region_countries
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadCountriesByRegion(App.getInstance().preferences.lastRegion)
    }

    private fun loadCountriesByRegion(regionName: String) {
        pbProcessing.visibility = View.VISIBLE
        countriesApi.getCountriesByRegion(regionName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            fillCountriesList(result)
                            fillRecyclerByCountries()
                            pbProcessing.visibility = View.GONE
                        },
                        {
                            pbProcessing.visibility = View.GONE
                        }
                )
    }

    private fun fillCountriesList(countriesResultList: List<CountryData>) {
        countriesList.addAll(countriesResultList)
    }

    private fun fillRecyclerByCountries() {
        val tmpList = ArrayList<String>()
        for (country in countriesList) {
            tmpList.add(country.name)
        }
        rvCountriesList.layoutManager = LinearLayoutManager(this)
        rvCountriesList.adapter = MenuAdapter(tmpList, null)
    }
}