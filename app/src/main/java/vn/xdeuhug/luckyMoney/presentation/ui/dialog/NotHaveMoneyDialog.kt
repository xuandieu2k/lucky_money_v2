package vn.xdeuhug.luckyMoney.presentation.ui.dialog

import android.content.Context
import android.content.DialogInterface
import android.media.MediaPlayer
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import vn.xdeuhug.luckyMoney.R
import vn.xdeuhug.luckyMoney.databinding.DialogNotHaveMoneyBinding

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class NotHaveMoneyDialog {
    class Builder(context: Context) :
        AppCompatDialog(context) {
        private var binding: DialogNotHaveMoneyBinding =
            DialogNotHaveMoneyBinding.inflate(LayoutInflater.from(context))

        lateinit var onCompleted: OnCompleted
        //
        private var mediaPlayer: MediaPlayer? = null

//        private var music = MusicCache.getMusic()

        fun onCompleted(onCompleted: OnCompleted): Builder = apply {
            this.onCompleted = onCompleted
        }

        init {
            setContentView(binding.root)
            setCanceledOnTouchOutside(false)
            setCancelable(false)
            setClickButton()
        }

        override fun setOnDismissListener(listener: DialogInterface.OnDismissListener?) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            super.setOnDismissListener(listener)
        }

        private fun setClickButton() {
            binding.btnAdd.setOnClickListener {
                playAudioPlayer()
                dismiss()
                onCompleted.onAdd()
            }

            binding.btnBack.setOnClickListener {
                playAudioPlayer()
                dismiss()
                onCompleted.onClose()
            }

        }

        private fun playAudioPlayer() {
            //set up MediaPlayer
//            if(music.isSaveCache && music.sound)
//            {
//                try {
//                    if(mediaPlayer == null)
//                    {
//                        mediaPlayer = MediaPlayer.create(context, R.raw.tap_notification)
//                    }
//                    mediaPlayer?.start()
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            }
            try {
                if(mediaPlayer == null)
                {
                    mediaPlayer = MediaPlayer.create(context, R.raw.tap_notification)
                }
                mediaPlayer?.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        interface OnCompleted {
            fun onClose()
            fun onAdd()
        }
    }
}