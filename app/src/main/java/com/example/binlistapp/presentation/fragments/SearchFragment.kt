package com.example.binlistapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.example.binlistapp.databinding.SearchFragmentBinding
import com.example.binlistapp.domain.SearchState
import com.example.binlistapp.presentation.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModel()
    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editText.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    viewModel.doRequest(binding.editText.text.toString())
                }
            }
            false
        }

        viewModel.binLiveData().observe(viewLifecycleOwner) { binResponse ->
            when (binResponse) {
                is SearchState.Error -> {

                }

                SearchState.Loading -> {
                    binding.progressBar.isGone = false
                }

                is SearchState.Success -> {
                    binding.progressBar.isGone = true
                    val locate =
                        binResponse.response.country.latitude.toString() + " " + binResponse.response.country.longitude.toString()
                    if(binResponse.response.country.name.isNullOrEmpty()){
                        binding.countryText.isGone = true
                        binding.countyDataText.isGone = true
                    }
                    else{
                        binding.countryText.isGone = false
                        binding.countyDataText.isGone = false
                    }
                    binding.countyDataText.text = binResponse.response.country.name
                    binding.locateDataText.text = locate
                    binding.cardTypeDataText.text = binResponse.response.scheme
                    binding.bankNameDataText.text = binResponse.response.bank.name
                    binding.urlDataText.text = binResponse.response.bank.url
                    binding.phoneDataText.text = binResponse.response.bank.phone
                    binding.cityDataText.text = binResponse.response.bank.city
                }
            }
        }
    }
}