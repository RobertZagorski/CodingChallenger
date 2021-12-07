package com.shiftkey.codingchallenge.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.shiftdetails.ShiftListFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShiftKeyActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createDestinationGraph()
    }

    private fun createDestinationGraph() {
        val startArgs = ShiftListFragmentArgs().toBundle()
        navController.setGraph(R.navigation.nav_graph, startArgs)
    }
}
