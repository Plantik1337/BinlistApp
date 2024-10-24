package com.example.binlistapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.binlistapp.R
import com.example.binlistapp.databinding.HistoryFragmentBinding
import com.example.binlistapp.presentation.CardInfoAdapter
import com.example.binlistapp.presentation.viewmodels.HistoryViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment(R.layout.history_fragment) {

    private val viewModel by viewModel<HistoryViewModel>()
    private lateinit var binding: HistoryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HistoryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            //val adapter = CardInfoAdapter()
        }
    }
}