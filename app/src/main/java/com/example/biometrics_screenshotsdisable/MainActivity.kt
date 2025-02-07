package com.example.biometrics_screenshotsdisable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biometrics_screenshotsdisable.databinding.ActivityMainBinding
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    companion object {
        var IS_AUTHENTICATED = false  // Boolean variable to track authentication status
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        // Obtain reference to the NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // Get the NavController
        navController = navHostFragment.navController
        // Set up the ActionBar with the Navigation UI
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) // Disable title display
        supportActionBar?.elevation = 0f // Ensure there's no elevation

        setupActionBarWithNavController(navController)
        onSupportNavigateUp()

        IS_AUTHENTICATED = false
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
