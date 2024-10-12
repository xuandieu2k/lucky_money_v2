//package vn.xdeuhug.luckyMoney.presentation.ui.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import vn.xdeuhug.luckyMoney.databinding.ItemNewsBinding
//import vn.xdeuhug.luckyMoney.domain.model.News
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 23 / 09 / 2024
// */
//class NewsAdapter(
//) : RecyclerView.Adapter<NewsAdapter.DataViewHolder>() {
//    private val newsList: ArrayList<News> = arrayListOf()
//
//    class DataViewHolder(private val binding: ItemNewsBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(news: News) {
//            binding.tvTimeCreated.text = news.pubDate
//            binding.tvContentNews.text = news.content
//            binding.tvTitle.text = news.title
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        DataViewHolder(
//            ItemNewsBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//
//    override fun getItemCount(): Int = newsList.size
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
//        holder.bind(newsList[position])
//
//    fun addData(list: List<News>) {
//        newsList.addAll(list)
//    }
//}