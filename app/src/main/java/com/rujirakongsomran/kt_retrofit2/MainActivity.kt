package com.rujirakongsomran.kt_retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rujirakongsomran.kt_retrofit2.databinding.ActivityMainBinding
import com.rujirakongsomran.kt_retrofit2.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getPost()
//        viewModel.myResponse.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Response", response.body()?.userId.toString())
//                Log.d("Response", response.body()?.id.toString())
////                Log.d("Response", response.body()?.title!!)
//                binding.textView.text = response.body()?.title!!
//
//                Log.d("Response", response.body()?.body!!)
//            } else {
//                Log.d("Response", response.errorBody().toString())
//                binding.textView.text = response.code().toString()
//            }
//        })

//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        binding.button.setOnClickListener {
//            val myNumber = binding.etNumber.text.toString()
//            viewModel.getPost2(Integer.parseInt(myNumber))
//
//            viewModel.myResponse2.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//
//                    binding.textView.text = response.body().toString()
//
//                } else {
//                    binding.textView.text = response.code().toString()
//                }
//            })
//        }

//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        binding.button.setOnClickListener {
//            val myNumber = binding.etNumber.text.toString()
//            viewModel.getCustomPosts(Integer.parseInt(myNumber))
//
//            viewModel.myCustomPosts.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    binding.textView.text = response.body().toString()
//
//                    response.body()?.forEach {
//                        Log.d("Response", it.userId.toString())
//                        Log.d("Response", it.id.toString())
//                        Log.d("Response", it.title)
//                        Log.d("Response", it.body)
//                        Log.d("Response", "----------------")
//                    }
//                } else {
//                    binding.textView.text = response.code().toString()
//                }
//            })
//        }

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        binding.button.setOnClickListener {
            val myNumber = binding.etNumber.text.toString()
            viewModel.getCustomQueryPosts(Integer.parseInt(myNumber), "id", "asc")

            viewModel.myCustomQueryPosts.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    binding.textView.text = response.body().toString()

                    response.body()?.forEach {
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "----------------")
                    }
                } else {
                    binding.textView.text = response.code().toString()
                }
            })
        }
    }
}