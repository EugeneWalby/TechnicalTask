package practicaltask.riseapps.com.practicaltask.ui.region_countries

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_region_countries.*
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.R.id.pbProcessing
import practicaltask.riseapps.com.practicaltask.R.id.rvCountriesList
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
        if (isInternetConnectionEstablished) {
            regionCountriesPresenter.loadCountriesDataByRegion(lastRegion)
        } else {
            showToast(R.string.msgCheckInternetConnection)
            showSnackBar()
        }
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

    private fun showSnackBar() {
        val snackbar = Snackbar.make(findViewById(R.id.rlRegionCountries), R.string.msgNoInternetConnection, Snackbar.LENGTH_LONG)
        val textView = snackbar.view.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }
}