package vn.xdeuhug.luckyMoney.presentation.ui.main

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.xdeuhug.luckyMoney.R
import vn.xdeuhug.luckyMoney.base.BaseActivity
import vn.xdeuhug.luckyMoney.databinding.ActivitySpinnerBinding
import vn.xdeuhug.luckyMoney.domain.model.Money
import vn.xdeuhug.luckyMoney.presentation.ui.dialog.LuckyBoxDialog
import vn.xdeuhug.luckyMoney.presentation.ui.dialog.NotHaveMoneyDialog
import vn.xdeuhug.luckyMoney.presentation.ui.dialog.SettingMoneyDialog
import vn.xdeuhug.luckyMoney.presentation.ui.viewmodel.SpinnerViewModel
import vn.xdeuhug.luckywheel.LuckyWheelView
import vn.xdeuhug.luckywheel.model.LuckyItem
import java.io.IOException

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class SpinnerActivity : BaseActivity(), LuckyWheelView.OnSpinnerListener,
    LuckyWheelView.LuckyRoundItemSelectedListener {
    private lateinit var binding: ActivitySpinnerBinding
    private val spinnerViewModel: SpinnerViewModel by viewModels()
    var data = ArrayList<LuckyItem>()
    private var twice = false

    private var mediaPlayer: MediaPlayer? = null

    private var dialog: NotHaveMoneyDialog.Builder? = null

    // You can use this method to check if the activity is currently resumed or not
    override fun getLayoutView(): View {
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        return binding.root
    }


    @RequiresApi(33)
    override fun initView() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (twice) {
                    finish()
                } else {
                    Toast.makeText(
                        baseContext,
                        getString(R.string.back_notification),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                twice = true
                Handler(Looper.getMainLooper()).postDelayed({
                    twice = false
                }, 2000)
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }


    override fun initData() {
//        initDataList()
        spinnerViewModel.initItems()
        binding.play.setOnClickListener {
            if (1 == 1) { // MoneyUtils.checkMoneyCacheExist()
                binding.luckyWheel.startLuckyWheelWithTargetIndex(1) //MoneyUtils.randomPosition(data)
                binding.luckyWheel.isTouchEnabled = false
            } else {
                if (dialog == null) {
                    dialog = NotHaveMoneyDialog.Builder(this@SpinnerActivity).onCompleted(object :
                        NotHaveMoneyDialog.Builder.OnCompleted {
                        override fun onClose() {
                            dialog = null
                        }

                        override fun onAdd() {
                            SettingMoneyDialog.Builder(this@SpinnerActivity)
                                .onCompleted(object : SettingMoneyDialog.Builder.OnCompleted {
                                    override fun onClose() {
                                        dialog = null
                                    }

                                    override fun onSave(listMoneyNew: ArrayList<Money>) {
//                                        ListMoneyCache.saveList(listMoneyNew)
                                        setDataMoney()
                                        dialog = null
                                    }

                                }).create()
                        }

                    })
                    dialog!!.create()
                }

            }
        }

        binding.luckyWheel.setOnSpinnerListener(this)
        binding.luckyWheel.setLuckyRoundItemSelectedListener(this)
    }

    override fun observerData() {
        spinnerViewModel.moneys.observe(this){
            if(it.isNotEmpty()){

            }
        }
    }

    override fun onResume() {
        super.onResume()
        playAudioPlayer()
    }

    private var lengthMP3 = 0

    override fun onPause() {
        super.onPause()
        mediaPlayer?.let {
            it.pause()
            lengthMP3 = it.currentPosition
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }

    private fun playAudioPlayer() {
        CoroutineScope(Dispatchers.IO).launch {
            //set up MediaPlayer
//            val music = MusicCache.getMusic()
//            if (music.isSaveCache && music.music) {
            try {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this@SpinnerActivity, R.raw.bg_lucky_money)
                    mediaPlayer!!.isLooping = true
                }
                mediaPlayer!!.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
//            }
        }
    }

    private fun create(context: Context, musicID: Int): MediaPlayer {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
        }
        mediaPlayer = MediaPlayer.create(context, musicID)
        try {
            mediaPlayer?.prepare()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return mediaPlayer!!
    }

    private fun initDataList() {
        val luckyItem = LuckyItem()
        luckyItem.topText = "Hộp quà may mắn"
        luckyItem.icon = R.drawable.ic_gift_box
        luckyItem.color = -0x1f4e
        data.add(luckyItem)

        val luckyItem1 = LuckyItem()
        luckyItem1.topText = "1,000"
        luckyItem1.icon = R.drawable.ic_1000_dong
        luckyItem1.color = -0xc20
        data.add(luckyItem1)

        val luckyItem2 = LuckyItem()
        luckyItem2.topText = "2,000"
        luckyItem2.icon = R.drawable.ic_2000_dong
        luckyItem2.color = -0x1f4e
        data.add(luckyItem2)

        val luckyItem3 = LuckyItem()
        luckyItem3.topText = "5,000"
        luckyItem3.icon = R.drawable.ic_5000_dong
        luckyItem3.color = -0x3380
        data.add(luckyItem3)

        //////////////////

        //////////////////
        val luckyItem4 = LuckyItem()
        luckyItem4.topText = "10,000"
        luckyItem4.icon = R.drawable.ic_10000_dong
        luckyItem4.color = -0xc20
        data.add(luckyItem4)

        val luckyItem5 = LuckyItem()
        luckyItem5.topText = "20,000"
        luckyItem5.icon = R.drawable.ic_20000_dong
        luckyItem5.color = -0x1f4e
        data.add(luckyItem5)

        val luckyItem6 = LuckyItem()
        luckyItem6.topText = "50,000"
        luckyItem6.icon = R.drawable.ic_50000_dong
        luckyItem6.color = -0x3380
        data.add(luckyItem6)
        //////////////////

        //////////////////////
        //////////////////

        //////////////////////
        val luckyItem7 = LuckyItem()
        luckyItem7.topText = "100,000"
        luckyItem7.icon = R.drawable.ic_100000_dong
        luckyItem7.color = -0xc20
        data.add(luckyItem7)

        val luckyItem8 = LuckyItem()
        luckyItem8.topText = "200,000"
        luckyItem8.icon = R.drawable.ic_200000_dong
        luckyItem8.color = -0x1f4e
        data.add(luckyItem8)


        val luckyItem9 = LuckyItem()
        luckyItem9.topText = "500,000"
        luckyItem9.icon = R.drawable.ic_500000_dong
        luckyItem9.color = -0x3380
        data.add(luckyItem9)
        ////////////////////////


        /////////////////////
        binding.luckyWheel.setData(data)
        binding.luckyWheel.setRandomRound()
        setDataMoney()
        binding.play.setOnClickListener {
            if (1 == 1) { // MoneyUtils.checkMoneyCacheExist()
                binding.luckyWheel.startLuckyWheelWithTargetIndex(1) //MoneyUtils.randomPosition(data)
                binding.luckyWheel.isTouchEnabled = false
            } else {
                if (dialog == null) {
                    dialog = NotHaveMoneyDialog.Builder(this@SpinnerActivity).onCompleted(object :
                        NotHaveMoneyDialog.Builder.OnCompleted {
                        override fun onClose() {
                            dialog = null
                        }

                        override fun onAdd() {
                            SettingMoneyDialog.Builder(this@SpinnerActivity)
                                .onCompleted(object : SettingMoneyDialog.Builder.OnCompleted {
                                    override fun onClose() {
                                        dialog = null
                                    }

                                    override fun onSave(listMoneyNew: ArrayList<Money>) {
//                                        ListMoneyCache.saveList(listMoneyNew)
                                        setDataMoney()
                                        dialog = null
                                    }

                                }).create()
                        }

                    })
                    dialog!!.create()
                }

            }
        }

        binding.luckyWheel.setOnSpinnerListener(this)
        binding.luckyWheel.setLuckyRoundItemSelectedListener(this)
    }

    private fun setDataMoney() {
//        binding.luckyWheel.setPredeterminedNumber(MoneyUtils.randomPosition(data))
//        binding.luckyWheel.setNotHaveMoney(!MoneyUtils.checkMoneyCacheExist())
    }

//    private fun getRandomIndex(): Int {
//        val rand = Random()
//        return rand.nextInt(data.size - 1) + 0
//    }
//
//    private fun getRandomRound(): Int {
//        val rand = Random()
//        return rand.nextInt(10) + 15
//    }
//
//    private fun getPosition1000Dong(): Int {
//        return data.indexOf(data.firstOrNull { it.topText == "1,000" })
//    }
//
//    private fun getRandomMoneyInCache(): Int {
//
//        return data.indexOf(data.firstOrNull { it.topText == "1,000" })
//    }

    override fun onNotHaveMoney() {
        if (dialog == null) {
            dialog = NotHaveMoneyDialog.Builder(this@SpinnerActivity).onCompleted(object :
                NotHaveMoneyDialog.Builder.OnCompleted {
                override fun onClose() {
                    dialog = null
                }

                override fun onAdd() {
                    SettingMoneyDialog.Builder(this@SpinnerActivity)
                        .onCompleted(object : SettingMoneyDialog.Builder.OnCompleted {
                            override fun onClose() {
                                dialog = null
                            }

                            override fun onSave(listMoneyNew: ArrayList<Money>) {
//                                        ListMoneyCache.saveList(listMoneyNew)
                                setDataMoney()
                                dialog = null
                            }

                        }).create()
                }

            })
            dialog!!.create()
        }
    }

    override fun luckyRoundItemSelected(index: Int) {
        if (this.isDestroyed) {
            if (index == 0) {
//                val moneyHighest = MoneyUtils.getHighestMoney()
                LuckyBoxDialog.Builder(this@SpinnerActivity.baseContext).onCompleted(object :
                    LuckyBoxDialog.Builder.OnCompleted {
                    override fun onOpen() {
//                        LuckyMoneyDialog.Builder(
//                            getContext(),
////                                LuckyMoneyDialog.Builder.D_500000
//                            moneyHighest.money
//                        )
//                            .onCompleted(object :
//                                LuckyMoneyDialog.Builder.OnCompleted {
//                                override fun onOpen() {
//                                    //
//                                    // Minus Number
//                                    MoneyUtils.minusNumberItem(
//                                        moneyHighest,
//                                        ListMoneyCache.getList()
//                                    )
//                                    //
//                                    setDataMoney()
//                                }
//
//                            }).create().show()
                    }

                }).create()
            } else {
                // Minus Number
//                MoneyUtils.minusNumberItem(
//                    ListMoneyCache.getList()
//                        .first { item ->
//                            item.money == data[it].topText.replace(",", "").toInt()
//                        },
//                    ListMoneyCache.getList()
//                )
//                //
//                LuckyMoneyDialog.Builder(
//                    getContext(),
//                    data[it].topText.replace(",", "").toInt()
//                )
//                    .onCompleted(object :
//                        LuckyMoneyDialog.Builder.OnCompleted {
//                        override fun onOpen() {
//                            //
//                        }
//
//                    }).create().show()
            }
        }
//        postDelayed({
//            binding.luckyWheel.isTouchEnabled = true
//        }, 3000)
        // set lại vị trí random
        setDataMoney()
    }

}