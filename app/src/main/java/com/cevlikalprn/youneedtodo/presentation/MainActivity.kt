package com.cevlikalprn.youneedtodo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cevlikalprn.youneedtodo.presentation.navigation.SetupNavigation
import com.cevlikalprn.youneedtodo.presentation.theme.YouNeedToDoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouNeedToDoTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}
