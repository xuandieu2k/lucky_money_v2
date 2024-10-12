package vn.xdeuhug.luckyMoney.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()
    }

    protected open fun initActivity() {
        initLayout()
        initView()
        initData()
        observerData()
    }

    protected abstract fun getLayoutView(): View

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract fun observerData()

    protected open fun initLayout() {
        setContentView(getLayoutView())
    }

}