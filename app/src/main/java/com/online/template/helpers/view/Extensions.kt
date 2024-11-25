package com.online.template.helpers.view

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.online.template.R

fun Fragment.navigate(action: NavDirections) = try {
    val navOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.enter)
        .setExitAnim(R.anim.exit)
        .setPopEnterAnim(R.anim.pop_enter)
        .setPopExitAnim(R.anim.pop_exit)
        .build()
    findNavController().navigate(action, navOptions)
} catch (e: Exception) {
    println("Error navigation: ${e.localizedMessage}")
}