package practicaltask.riseapps.com.practicaltask.ui.region_countries

import practicaltask.riseapps.com.practicaltask.network.model.CountryData
import practicaltask.riseapps.com.practicaltask.ui.base.BaseView

interface RegionCountriesView: BaseView {
    fun showProgress()
    fun hideProgress()
    fun fillRecyclerByCountriesData(countriesList: List<CountryData>)
}