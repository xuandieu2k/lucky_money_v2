//package vn.xdeuhug.luckyMoney.data.repository
//
//import vn.xdeuhug.luckyMoney.data.local.NewsDao
//import vn.xdeuhug.luckyMoney.data.remote.ApiService
//import vn.xdeuhug.luckyMoney.domain.model.News
//import vn.xdeuhug.luckyMoney.domain.repository.NewsRepository
//import javax.inject.Inject
//import javax.inject.Singleton
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 09 / 10 / 2024
// */
//@Singleton
//class NewsRepositoryImpl @Inject constructor(
//    private val apiService: ApiService,
//    private val newsDao: NewsDao
//) : NewsRepository {
//
//    override suspend fun getNewsFromRemote(country: String, category: String): List<News> {
//        return apiService.getNews(country, category).newses
//    }
//
//    override suspend fun getNewsFromLocal(): List<News> {
//        return newsDao.getAllItems()
//    }
//
//    override suspend fun saveNews(items: List<News>) {
//        return newsDao.insertItems(items)
//    }
//
//}