package com.rujirakongsomran.kt_retrofit2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rujirakongsomran.kt_retrofit2.model.Affirmation
import com.rujirakongsomran.kt_retrofit2.model.Post
import com.rujirakongsomran.kt_retrofit2.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseAffirmation: MutableLiveData<Response<Affirmation>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomQueryPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomQueryMapPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getAffirmation() {
        viewModelScope.launch {
            val response = repository.getAffirmation()
            myResponseAffirmation.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId: Int) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId)
            myCustomPosts.value = response
        }
    }

    fun getCustomQueryPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomQueryPosts(userId, sort, order)
            myCustomQueryPosts.value = response
        }
    }

    fun getCustomQueryMapPosts(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            val response = repository.getCustomQueryMapPosts(userId, options)
            myCustomQueryMapPosts.value = response
        }
    }
}