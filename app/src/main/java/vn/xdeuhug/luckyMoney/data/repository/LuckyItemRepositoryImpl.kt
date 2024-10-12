package vn.xdeuhug.luckyMoney.data.repository

import vn.xdeuhug.luckyMoney.data.local.LuckyItemDao
import vn.xdeuhug.luckyMoney.domain.model.LuckyItem
import vn.xdeuhug.luckyMoney.domain.repository.LuckyItemRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 11 / 10 / 2024
 */
@Singleton
class LuckyItemRepositoryImpl @Inject constructor(
    private val luckyItemDao: LuckyItemDao
) : LuckyItemRepository {
    override fun getItems(): List<LuckyItem> {
        return luckyItemDao.getAllItems()
    }

    override fun saveItems(items: List<LuckyItem>) {
        return luckyItemDao.insertItems(items)
    }

    override fun insertItem(item: LuckyItem) {
        return luckyItemDao.insertItem(item)
    }

    override fun deleteItem(id: Int) {
        return luckyItemDao.deleteItem(id)
    }

    override fun deleteAll() {
        return luckyItemDao.deleteAll()
    }
}