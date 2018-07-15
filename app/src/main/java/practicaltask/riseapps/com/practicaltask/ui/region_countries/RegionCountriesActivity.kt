package practicaltask.riseapps.com.practicaltask.ui.region_countries

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_region_countries.*
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.core.App
import practicaltask.riseapps.com.practicaltask.network.model.CountryData
import practicaltask.riseapps.com.practicaltask.ui.adapter.CountriesAdapter
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity

class RegionCountriesActivity : BaseActivity(), RegionCountriesView {
    companion object {
        private val lastRegion = App.getInstance().preferences.lastRegion
        private val regionCountriesPresenter = RegionCountriesPresenter()
    }

    override fun provideLayout(): Int {
        return R.layout.activity_region_countries
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        regionCountriesPresenter.setView(this)
        showProgress()
        regionCountriesPresenter.loadCountriesDataByRegion(lastRegion)
    }

    override fun showProgress() {
        pbProcessing.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        pbProcessing.visibility = View.GONE
    }

    override fun fillRecyclerByCountriesData(countriesList: List<CountryData>) {
        rvCountriesList.layoutManager = LinearLayoutManager(this)
        rvCountriesList.adapter = CountriesAdapter(countriesList)
        hideProgress()
    }
}