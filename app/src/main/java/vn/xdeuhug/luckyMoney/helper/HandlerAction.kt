package vn.xdeuhug.luckyMoney.helper

import android.os.Handler
import android.os.Looper
import android.os.SystemClock

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
interface HandlerAction {

    companion object {
        val HANDLER: Handler = Handler(Looper.getMainLooper())
    }

    fun getHandler(): Handler {
        return HANDLER
    }

    fun post(runnable: Runnable): Boolean {
        return postDelayed(runnable, 0)
    }

    fun postDelayed(runnable: Runnable, delayMillis: Long): Boolean {
        return postAtTime(
            runnable,
            SystemClock.uptimeMillis() + if (delayMillis < 0) 0 else delayMillis
        )
    }

    fun postAtTime(runnable: Runnable, uptimeMillis: Long): Boolean {
        return HANDLER.postAtTime(runnable, this, uptimeMillis)
    }

    fun removeCallbacks(runnable: Runnable) {
        HANDLER.removeCallbacks(runnable)
    }

    fun removeCallbacks() {
        HANDLER.removeCallbacksAndMessages(this)
    }
}