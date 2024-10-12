//package vn.xdeuhug.luckyMoney.domain.usecase
//
//import android.util.Log
//import vn.xdeuhug.luckyMoney.domain.model.News
//import vn.xdeuhug.luckyMoney.domain.repository.NewsRepository
//import javax.inject.Inject
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 09 / 10 / 2024
// */
//class GetNewsUseCase @Inject constructor(
//    private val repository: NewsRepository
//) {
//    init {
//        Log.d("GetMainItemsUseCase", "Initialized")
//    }
//
//    suspend operator fun invoke(country: String, category: String): List<News> {
//        val items = repository.getNewsFromRemote(country, category)
//        Log.d("GetNewsUseCase log:", "items: $items")
//        repository.saveNews(items) // Save to local database
//        return items
//    }
//}