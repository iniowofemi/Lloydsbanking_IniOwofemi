package com.example.lloydsbanking_challenge_iniowofemi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lloydsbanking_challenge_iniowofemi.databinding.DrawerLayoutBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.view.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: DrawerLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.mainActivity.customName.toolbar.setOnMenuItemClickListener { it ->
//            when (it) {
//                 -> {}
//                else -> {}
//            }
//        }
        setSupportActionBar(binding.mainActivity.customName.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.naviView
        val hostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = hostFragment.findNavController()
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.animeFragment
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        onSupportNavigateUp()
    }

     override fun onSupportNavigateUp(): Boolean {
         val navController = findNavController(R.id.nav_host_fragment_content_main)
         Log.d("String", "Back Button Pressed")
         return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

