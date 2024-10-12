//package vn.xdeuhug.luckyMoney.domain.model
//
//import androidx.room.Entity
//import androidx.room.Ignore
//import androidx.room.PrimaryKey
//import com.google.gson.annotations.SerializedName
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 23 / 09 / 2024
// */
//@Entity(tableName = "news")
//data class News(
//    @PrimaryKey var id: Int,
//    @SerializedName("article_id") var articleId: String = "",
//    @SerializedName("content") var content: String? = "",
//    @SerializedName("description") var description: String? = "",
//
//    @SerializedName("image_url") var imageUrl: String? = "",
//    @SerializedName("language") var language: String = "",
//    @SerializedName("link") var link: String? = "",
//    @SerializedName("pubDate") var pubDate: String = "",
//
//    @SerializedName("source_id") var sourceId: String = "",
//
//    @SerializedName("source_priority") var sourcePriority: Int = 0,
//    @SerializedName("title") var title: String? = "",
//
//    @SerializedName("video_url") var videoUrl: String? = ""
//) {
//    @Ignore
//    @SerializedName("category")
//    var category: ArrayList<String> = arrayListOf()
//
//    @Ignore
//    @SerializedName("keywords")
//    var keywords: ArrayList<String> = arrayListOf()
//
//    @Ignore
//    @SerializedName("country")
//    var country: ArrayList<String> = arrayListOf()
//
//    @Ignore
//    @SerializedName("creator")
//    var creator: ArrayList<String> = arrayListOf()
//}