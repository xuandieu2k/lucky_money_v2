package vn.xdeuhug.luckyMoney.presentation.ui.dialog

import android.animation.Animator
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import vn.xdeuhug.luckyMoney.R
import vn.xdeuhug.luckyMoney.databinding.DialogLuckyBoxBinding
import vn.xdeuhug.luckyMoney.databinding.DialogLuckyMoneyBinding

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class LuckyBoxDialog {
    class Builder(context: Context) :
        AppCompatDialog(context) {
        private var binding: DialogLuckyBoxBinding =
            DialogLuckyBoxBinding.inflate(LayoutInflater.from(context))

        lateinit var onCompleted: OnCompleted

        fun onCompleted(onCompleted: OnCompleted): Builder = apply {
            this.onCompleted = onCompleted
        }

        private var countClick = 0

        init {
            setContentView(binding.root)
//            setAnimStyle(AnimAction.ANIM_TOAST)
            setCanceledOnTouchOutside(false)
//            setBackgroundDimEnabled(true)
            setCancelable(false)
//            binding.btnOpenBox.setOnClickListener {
//                binding.btnOpenBox.isEnabled = false
//                postDelayed({
//                    binding.btnOpenBox.isEnabled = true
//                },2000)
//                if(countClick == 0)
//                {
//                    //
//                }
//                countClick++
//            }

            binding.btnOpenBox.addAnimatorListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator) {
                    //
                }

                override fun onAnimationEnd(animation: Animator) {
                    //Add your code here for animation end
                    dismiss()
                    onCompleted.onOpen()
                }

                override fun onAnimationCancel(animation: Animator) {
                    //
                }

                override fun onAnimationStart(animation: Animator) {
                    //
                }

            })
        }

        interface OnCompleted {
            fun onOpen()
        }
    }
}