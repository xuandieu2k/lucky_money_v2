package vn.xdeuhug.luckyMoney.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import vn.xdeuhug.luckyMoney.base.BaseActivity
import vn.xdeuhug.luckyMoney.databinding.ActivityHomeBinding

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun getLayoutView(): View {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        binding.btnStart.setOnClickListener{
            try{
                Timber.tag("Log error").e("HomeActivity")
                startActivity(Intent(this, SpinnerActivity::class.java))
                finish()
            }catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }

    override fun initData() {
        //
    }

    override fun observerData() {
        //
    }

}