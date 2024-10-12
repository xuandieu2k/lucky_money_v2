//package vn.xdeuhug.luckyMoney.data.remote
//
//import retrofit2.http.GET
//import retrofit2.http.Query
//import vn.xdeuhug.luckyMoney.domain.model.ResponseNewsData
//import javax.inject.Singleton
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 21 / 09 / 2024
// */
//@Singleton
//interface ApiService {
//    @GET("api/1/news")
//    suspend fun getNews(
//        @Query("country") country: String = "vi",
//        @Query("category") category: String = "top",
//        @Query("apikey") apikey: String = "pub_306097c75eb9654ca735dc6fc7a5cf8862c0c"
//    ): ResponseNewsData
//}