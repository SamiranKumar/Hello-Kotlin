package com.skh.mvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.skh.mvvm.databinding.FragmentMainBinding
import com.skh.mvvm.viewModel.MainViewModel


/**
Created by Samiran Kumar on 13,September,2022
 **/

/**
 *      MainFragment
 *      - shows the UI
 *      - listens to viewModel for updates on UI
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    // Create a viewModel
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        fragmentTextUpdateObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
      //  binding = null
    }

    // Setup the button in our fragment to call getUpdatedText method in viewModel
    private fun setupClickListeners() {
        binding.fragmentButton.setOnClickListener { viewModel.getUpdatedText() }
    }

    // Observer is waiting for viewModel to update our UI
    private fun fragmentTextUpdateObserver() {
        viewModel.uiTextLiveData.observe(viewLifecycleOwner) { updatedText ->
            binding.fragmentTextView.text = updatedText
        }
    }


}