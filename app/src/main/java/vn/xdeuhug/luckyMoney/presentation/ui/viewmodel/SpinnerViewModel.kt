package vn.xdeuhug.luckyMoney.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import vn.xdeuhug.luckyMoney.R
import vn.xdeuhug.luckyMoney.domain.model.LuckyItem
import vn.xdeuhug.luckyMoney.domain.model.Money
import vn.xdeuhug.luckyMoney.domain.usecase.GetMoneyUseCase
import javax.inject.Inject

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@HiltViewModel
class SpinnerViewModel @Inject constructor(
    private val getMoneyUseCase: GetMoneyUseCase
) : ViewModel() {
    private val _moneys = MutableLiveData<List<Money>>()
    val moneys: LiveData<List<Money>> = _moneys

    fun getMoneys() {
        viewModelScope.launch {
            _moneys.value = getMoneyUseCase()
        }
    }

    fun insertMoneys(moneys: List<Money>) {
        viewModelScope.launch {
            getMoneyUseCase.insertItems(moneys)
        }
    }

    fun initItems(): List<LuckyItem> {
        val items: MutableList<LuckyItem> = mutableListOf()
        val luckyItem = LuckyItem()
        luckyItem.topText = "Hộp quà may mắn"
        luckyItem.icon = R.drawable.ic_gift_box
        luckyItem.color = -0x1f4e
        items.add(luckyItem)

        val luckyItem1 = LuckyItem()
        luckyItem1.topText = "1,000"
        luckyItem1.icon = R.drawable.ic_1000_dong
        luckyItem1.color = -0xc20
        items.add(luckyItem1)

        val luckyItem2 = LuckyItem()
        luckyItem2.topText = "2,000"
        luckyItem2.icon = R.drawable.ic_2000_dong
        luckyItem2.color = -0x1f4e
        items.add(luckyItem2)

        val luckyItem3 = LuckyItem()
        luckyItem3.topText = "5,000"
        luckyItem3.icon = R.drawable.ic_5000_dong
        luckyItem3.color = -0x3380
        items.add(luckyItem3)

        //////////////////

        //////////////////
        val luckyItem4 = LuckyItem()
        luckyItem4.topText = "10,000"
        luckyItem4.icon = R.drawable.ic_10000_dong
        luckyItem4.color = -0xc20
        items.add(luckyItem4)

        val luckyItem5 = LuckyItem()
        luckyItem5.topText = "20,000"
        luckyItem5.icon = R.drawable.ic_20000_dong
        luckyItem5.color = -0x1f4e
        items.add(luckyItem5)

        val luckyItem6 = LuckyItem()
        luckyItem6.topText = "50,000"
        luckyItem6.icon = R.drawable.ic_50000_dong
        luckyItem6.color = -0x3380
        items.add(luckyItem6)
        //////////////////

        //////////////////////
        //////////////////

        //////////////////////
        val luckyItem7 = LuckyItem()
        luckyItem7.topText = "100,000"
        luckyItem7.icon = R.drawable.ic_100000_dong
        luckyItem7.color = -0xc20
        items.add(luckyItem7)

        val luckyItem8 = LuckyItem()
        luckyItem8.topText = "200,000"
        luckyItem8.icon = R.drawable.ic_200000_dong
        luckyItem8.color = -0x1f4e
        items.add(luckyItem8)


        val luckyItem9 = LuckyItem()
        luckyItem9.topText = "500,000"
        luckyItem9.icon = R.drawable.ic_500000_dong
        luckyItem9.color = -0x3380
        items.add(luckyItem9)
        return items
    }
}