package com.example.binlistapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import com.example.binlistapp.data.network.CardResponse
import com.example.binlistapp.databinding.SearchFragmentBinding
import com.example.binlistapp.presentation.viewmodels.SearchViewModel

class SearchFragment : Fragment() {
    private val viewModel = SearchViewModel()
    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        fun getCardInfo(cardInfo: CardResponse) {
            val locate =
                cardInfo.country.latitude.toString() + " " + cardInfo.country.longitude.toString()
            binding.countyDataText.text = cardInfo.country.name
            binding.locateDataText.text = locate
            binding.cardTypeDataText.text = cardInfo.scheme
            binding.bankNameDataText.text = cardInfo.bank.name
            binding.urlDataText.text = cardInfo.bank.url
            binding.phoneDataText.text = cardInfo.bank.phone
            binding.cityDataText.text = cardInfo.bank.city
        }
        viewModel.binLiveData().observe(viewLifecycleOwner) { binData ->
            Log.i("response", binData.toString())
            getCardInfo(binData)
        }
    }
}