package vn.xdeuhug.luckyMoney.data.repository

import vn.xdeuhug.luckyMoney.data.local.MoneyDao
import vn.xdeuhug.luckyMoney.domain.model.Money
import vn.xdeuhug.luckyMoney.domain.repository.MoneyRepository
import javax.inject.Singleton

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Singleton
class MoneyRepositoryImpl(private val moneyDao: MoneyDao) : MoneyRepository {
    override fun getListMoney(): List<Money> {
        return moneyDao.getMoney()
    }

    override fun insertMoney(money: Money) {
        return moneyDao.insertItem(money)
    }

    override fun insertListMoney(listMoney: List<Money>) {
        return moneyDao.insertItems(listMoney)
    }

    override fun deleteMoney(money: Money) {
        return moneyDao.deleteAll()
    }

    override fun getItem(id: Int): Money {
        return moneyDao.getItem(id)
    }
}