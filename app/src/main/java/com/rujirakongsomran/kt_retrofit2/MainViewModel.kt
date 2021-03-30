package com.rujirakongsomran.kt_retrofit2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rujirakongsomran.kt_retrofit2.model.Post
import com.rujirakongsomran.kt_retrofit2.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Post> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {

            val response = repository.getPost()
            myResponse.value = response

        }
    }
}