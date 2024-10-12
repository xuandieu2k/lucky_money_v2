//package vn.xdeuhug.luckyMoney.presentation.ui.main
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import dagger.hilt.android.AndroidEntryPoint
//import vn.xdeuhug.luckyMoney.databinding.ActivityNewsBinding
//import vn.xdeuhug.luckyMoney.presentation.ui.adapter.NewsAdapter
//import vn.xdeuhug.luckyMoney.presentation.ui.viewmodel.NewsViewModel
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 23 / 09 / 2024
// */
//@AndroidEntryPoint
//class NewsActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityNewsBinding
//    private val viewModel: NewsViewModel by viewModels()
//    private lateinit var adapter: NewsAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityNewsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        setupUI()
//        setupObserver()
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    private fun setupObserver() {
//        viewModel.news.observe(this) {
//            it?.let {
//                it.data?.let { it1 ->
//                    adapter.addData(it1)
//                    adapter.notifyDataSetChanged()
//                }
//            }
//        }
//    }
//
//    private fun setupUI() {
//        adapter = NewsAdapter()
//        binding.rvNews.adapter = adapter
//        binding.rvNews.layoutManager = LinearLayoutManager(this)
//        binding.rvNews.addItemDecoration(
//            DividerItemDecoration(
//                binding.rvNews.context,
//                (binding.rvNews.layoutManager as LinearLayoutManager).orientation
//            )
//        )
//        // Load main items
//        viewModel.loadNews("vi", "sports")
//    }
//
//}