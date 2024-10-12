package vn.xdeuhug.luckyMoney.presentation.ui.main

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import dagger.hilt.android.AndroidEntryPoint
import vn.xdeuhug.luckyMoney.base.BaseActivity
import vn.xdeuhug.luckyMoney.databinding.ActivitySplashBinding

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun getLayoutView(): View {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 2000)
    }

    override fun initData() {
        //
    }

    override fun observerData() {
        //
    }

}