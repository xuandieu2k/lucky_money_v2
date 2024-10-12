//package vn.xdeuhug.luckyMoney.presentation.ui.viewmodel
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import vn.xdeuhug.luckyMoney.domain.model.News
//import vn.xdeuhug.luckyMoney.domain.usecase.GetNewsUseCase
//import vn.xdeuhug.luckyMoney.utils.Resource
//import javax.inject.Inject
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 09 / 10 / 2024
// */
//@HiltViewModel
//class NewsViewModel @Inject constructor(
//    private val getNewsUseCase: GetNewsUseCase
//) : ViewModel() {
//
//    private val _news = MutableLiveData<Resource<List<News>>>()
//    val news: LiveData<Resource<List<News>>> = _news
//
//    init {
//        Log.d("MainViewModel log:", "ViewModel initialized")
//    }
//
//    fun loadNews(country: String, category: String) {
//        viewModelScope.launch {
//            _news.value = Resource.Loading()
//            try {
//                val items = getNewsUseCase(country,category)
//                Log.d("NewsViewModel log:", "items: $items")
//                _news.value = Resource.Success(items)
//            } catch (e: Exception) {
//                Log.d("NewsViewModel log error:", "items: $e")
//                _news.value = Resource.Error(e.message ?: "An error occurred")
//            }
//        }
//    }
//}