package vn.xdeuhug.luckyMoney.presentation.ui.dialog

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import vn.xdeuhug.luckyMoney.R
import vn.xdeuhug.luckyMoney.databinding.DialogSettingMoneyBinding
import vn.xdeuhug.luckyMoney.domain.model.Money
import vn.xdeuhug.luckyMoney.presentation.ui.adapter.MoneyAdapter
import vn.xdeuhug.luckyMoney.utils.AppUtils

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class SettingMoneyDialog {
    class Builder(context: Context) :
        AppCompatDialog(context), MoneyAdapter.OnClickItem {
        private var binding: DialogSettingMoneyBinding =
            DialogSettingMoneyBinding.inflate(LayoutInflater.from(context))

        lateinit var onCompleted: OnCompleted

        //
        private var mediaPlayer: MediaPlayer? = null

//        private var music = MusicCache.getMusic()

        private lateinit var moneyAdapter: MoneyAdapter

        private var listMoney = ArrayList<Money>()

        fun onCompleted(onCompleted: OnCompleted): Builder = apply {
            this.onCompleted = onCompleted
        }

        init {
            setContentView(binding.root)
//            setWidth(Resources.getSystem().displayMetrics.widthPixels * 9 / 10)
//            setHeight(Resources.getSystem().displayMetrics.heightPixels * 6 / 10)
//            setAnimStyle(AnimAction.ANIM_TOAST)
            setCanceledOnTouchOutside(false)
//            setBackgroundDimEnabled(true)
            setCancelable(false)
            setUpMoney()
            setOnCompleted()
        }

        private fun setOnCompleted() {
            binding.btnSave.setOnClickListener {
                playAudioPlayer()
                dismiss()
                val list = ArrayList<Money>()
                list.addAll(listMoney)
                onCompleted.onSave(list)
            }

            binding.btnBack.setOnClickListener {
                playAudioPlayer()
                dismiss()
                onCompleted.onClose()
            }
        }

        override fun setOnDismissListener(listener: DialogInterface.OnDismissListener?) {
            super.setOnDismissListener(listener)
            mediaPlayer?.stop()
        }

        private fun playAudioPlayer() {
            //set up MediaPlayer
//            if (music.isSaveCache && music.sound) {
            try {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.tap_notification)
                    mediaPlayer?.prepare()
                }
                mediaPlayer?.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
//            }
        }

        @SuppressLint("NotifyDataSetChanged")
        private fun setUpMoney() {
            moneyAdapter = MoneyAdapter(context)
            moneyAdapter.onClickItem = this
            initListMoney()
            moneyAdapter.setData(listMoney)
            moneyAdapter.notifyDataSetChanged()
            AppUtils.initRecyclerView(binding.rvMoney, moneyAdapter)
        }

        private fun initListMoney() {
            val listCache = ArrayList<Money>()
            val money_1000 = Money()
            money_1000.name = "1,000"
            money_1000.money = 1000
            money_1000.money = 0

            val money_2000 = Money()
            money_2000.name = "2,000"
            money_2000.money = 2000
            money_2000.money = 0

            val money_5000 = Money()
            money_5000.name = "5,000"
            money_5000.money = 5000
            money_5000.money = 0

            val money_10000 = Money()
            money_10000.name = "10,000"
            money_10000.money = 10000
            money_10000.money = 0

            val money_20000 = Money()
            money_20000.name = "20,000"
            money_20000.money = 20000
            money_20000.money = 0

            val money_50000 = Money()
            money_50000.name = "50,000"
            money_50000.money = 50000
            money_50000.money = 0

            val money_100000 = Money()
            money_100000.name = "100,000"
            money_100000.money = 100000
            money_100000.money = 0

            val money_200000 = Money()
            money_200000.name = "200,000"
            money_200000.money = 200000
            money_200000.money = 0

            val money_500000 = Money()
            money_500000.name = "500,000"
            money_500000.money = 500000
            money_500000.money = 0
            listMoney.clear()
            listMoney.add(money_1000)
            listMoney.add(money_2000)
            listMoney.add(money_5000)
            listMoney.add(money_10000)
            listMoney.add(money_20000)
            listMoney.add(money_50000)
            listMoney.add(money_100000)
            listMoney.add(money_200000)
            listMoney.add(money_500000)
//            if(ListMoneyCache.getList().isNotEmpty())
//            {
//                listMoney.clear()
//                listMoney.addAll(listCache)
//            }else{
//                val money_1000 = Money()
//                money_1000.name = "1,000"
//                money_1000.money = 1000
//                money_1000.money = 0
//
//                val money_2000 = Money()
//                money_2000.name = "2,000"
//                money_2000.money = 2000
//                money_2000.money = 0
//
//                val money_5000 = Money()
//                money_5000.name = "5,000"
//                money_5000.money = 5000
//                money_5000.money = 0
//
//                val money_10000 = Money()
//                money_10000.name = "10,000"
//                money_10000.money = 10000
//                money_10000.money = 0
//
//                val money_20000 = Money()
//                money_20000.name = "20,000"
//                money_20000.money = 20000
//                money_20000.money = 0
//
//                val money_50000 = Money()
//                money_50000.name = "50,000"
//                money_50000.money = 50000
//                money_50000.money = 0
//
//                val money_100000 = Money()
//                money_100000.name = "100,000"
//                money_100000.money = 100000
//                money_100000.money = 0
//
//                val money_200000 = Money()
//                money_200000.name = "200,000"
//                money_200000.money = 200000
//                money_200000.money = 0
//
//                val money_500000 = Money()
//                money_500000.name = "500,000"
//                money_500000.money = 500000
//                money_500000.money = 0
//                listMoney.clear()
//                listMoney.add(money_1000)
//                listMoney.add(money_2000)
//                listMoney.add(money_5000)
//                listMoney.add(money_10000)
//                listMoney.add(money_20000)
//                listMoney.add(money_50000)
//                listMoney.add(money_100000)
//                listMoney.add(money_200000)
//                listMoney.add(money_500000)
//            }
        }

        interface OnCompleted {
            fun onClose()
            fun onSave(listMoneyNew: ArrayList<Money>)
        }

        override fun onMinus(position: Int, item: Money) {
//            hideKeyboard(binding.root)
            playAudioPlayer()
            if (item.money <= 99) {
                item.money -= 1
                if (item.money < 0) {
                    item.money = 0
                }
                moneyAdapter.notifyItemChanged(position)
            } else {
                Toast.makeText(
                    context,
                    context.getString(R.string.max_number_99),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        override fun onPlus(position: Int, item: Money) {
//            hideKeyboard(binding.root)
            playAudioPlayer()
            if (item.money < 99) {
                item.money += 1
                moneyAdapter.notifyItemChanged(position)
            } else {
                item.money = 99
                Toast.makeText(
                    context,
                    context.getString(R.string.max_number_99),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}