package com.example.binlistapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.binlistapp.R
import com.example.binlistapp.RetrofitClient
import com.example.binlistapp.SearchViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binCode = "45717360"

        // Получаем NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Настраиваем BottomNavigationView с NavController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setupWithNavController(navController)



//        lifecycleScope.launch {
//            try {
//                val binInfo = RetrofitClient.api.getCardInfo(binCode)
//                Log.d("BIN_INFO", "Страна: ${binInfo.country?.name}, Банк: ${binInfo.bank?.name}")
//                Log.d("BinWholeInfo", binInfo.country.latitude.toString())
//            } catch (e: HttpException) {
//                Log.e("BIN_INFO", "Ошибка HTTP: ${e.code()}")
//            } catch (e: Exception) {
//                Log.e("BIN_INFO", "Ошибка: ${e.message}")
//            }
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}