package practicaltask.riseapps.com.practicaltask.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity


class SplashActivity : BaseActivity() {
    companion object {
        private const val DELAY_BEFORE_MOVE = 2000L
    }

    override fun provideLayout(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        waitUntilNextScreen()
    }

    private fun waitUntilNextScreen() {
        pbLoading.visibility = View.VISIBLE
        Handler().postDelayed(
                {
                    moveToScreen(MainActivity::class.java)
                    pbLoading.visibility = View.GONE
                },
                DELAY_BEFORE_MOVE)
    }
}