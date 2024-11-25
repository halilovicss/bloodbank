package com.online.template.helpers.navigation

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.online.template.features.main.MainActivity

class MainNavigationHelper(
    private val activity: MainActivity,
    private val toolbar: Toolbar,
    private val bottomNav: BottomNavigationView
) {

    private var navController: LiveData<NavController>? = null
    fun navigate(deepLink: String) {
        // TODO: should revisit
        Handler(Looper.getMainLooper()).postDelayed(
            {
                navController?.value?.popBackStack()
                navController?.value?.navigate(Uri.parse(deepLink))
            }, 100
        )
    }

    fun navigateUp() = navController?.value?.navigateUp() ?: false

    fun navigate(destinationId: Int, bundle: Bundle? = null) {
        navController?.value?.navigate(destinationId, bundle)
    }
}
