package vn.xdeuhug.luckyMoney.domain.repository

import vn.xdeuhug.luckyMoney.domain.model.Money

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
interface MoneyRepository {
    fun getListMoney(): List<Money>
    fun insertMoney(money: Money)
    fun insertListMoney(listMoney: List<Money>)
    fun deleteMoney(money: Money)
    fun getItem(id: Int): Money
}