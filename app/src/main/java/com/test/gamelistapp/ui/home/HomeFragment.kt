package com.test.gamelistapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.test.gamelistapp.R
import com.test.gamelistapp.databinding.FragmentHomeBinding
import com.test.gamelistapp.ui.helper.ListGameAdapter
import com.test.gamelistapp.ui.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var adapters: ListGameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        adapters = ListGameAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater, container, /* attachToParent */false
        )
        setupRecyclerview()
        initData()
        return binding.root
    }

    private fun setupRecyclerview(){
        with(binding.recyclerview){
            adapter = adapters
            layoutManager = GridLayoutManager(requireContext(),3)
        }
    }

    private fun initData(){
        lifecycleScope.launch {
            mainViewModel.getGames().collectLatest{ paging ->
                adapters.submitData(paging)
            }
        }
    }


}