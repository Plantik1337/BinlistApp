package com.example.binlistapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.binlistapp.R
import com.example.binlistapp.RetrofitClient
import com.example.binlistapp.SearchViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binCode = "45717360"

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)


//        lifecycleScope.launch {
//            try {
//                val binInfo = RetrofitClient.api.getCardInfo(binCode)
//                Log.d("BIN_INFO", "Страна: ${binInfo.country?.name}, Банк: ${binInfo.bank?.name}")
//            } catch (e: HttpException) {
//                Log.e("BIN_INFO", "Ошибка HTTP: ${e.code()}")
//            } catch (e: Exception) {
//                Log.e("BIN_INFO", "Ошибка: ${e.message}")
//            }
//        }
    }
}