package com.skh.mvvm.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.skh.mvvm.databinding.ActivityMainBinding
import com.skh.mvvm.network.ApiState
import com.skh.mvvm.viewModel.MainViewModel
import com.skh.mvvm.viewModel.PostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private lateinit var activity: Activity

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activity = this

        setRecycleItem()

        mainViewModel.getPost()
        lifecycleScope.launchWhenCreated {
            mainViewModel._postStateFlow.collect { it ->
                when (it) {
                    is ApiState.Loading -> {
                        binding.pb.isVisible = true
                        binding.rvList.isVisible = false
                        logPrint("Loading:${it}")
                    }

                    is ApiState.Failure -> {
                        binding.pb.isVisible = false
                        binding.rvList.isVisible = false
                        logPrint("Failure:${it.throwable}")
                    }


                    is ApiState.Success -> {
                        binding.pb.isVisible = false
                        binding.rvList.isVisible = true

                        postAdapter.setData(it.data)

                        logPrint("Success:${it.data}")
                    }

                    is ApiState.Empty -> {

                        logPrint("Loading:${it}")
                    }
                }

            }
        }

    }


    private fun setRecycleItem() {
        postAdapter = PostAdapter()
        val m = LinearLayoutManager(activity)
        m.orientation = LinearLayoutManager.VERTICAL
        binding.rvList.apply {
            setHasFixedSize(false)
            layoutManager = m
            adapter = postAdapter
        }


    }

    private fun logPrint(message: String) {
        Log.d("Main", message)
    }
}