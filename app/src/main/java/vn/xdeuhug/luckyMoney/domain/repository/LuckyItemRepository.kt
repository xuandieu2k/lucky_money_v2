package vn.xdeuhug.luckyMoney.domain.repository

import vn.xdeuhug.luckyMoney.domain.model.LuckyItem

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 11 / 10 / 2024
 */
interface LuckyItemRepository {
    fun getItems(): List<LuckyItem>
    fun saveItems(items: List<LuckyItem>)
    fun insertItem(item: LuckyItem)
    fun deleteItem(id: Int)
    fun deleteAll()
}