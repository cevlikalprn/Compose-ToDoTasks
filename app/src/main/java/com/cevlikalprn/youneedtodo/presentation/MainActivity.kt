package com.cevlikalprn.youneedtodo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.cevlikalprn.youneedtodo.presentation.navigation.AppNavigation
import com.cevlikalprn.youneedtodo.presentation.theme.YouNeedToDoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouNeedToDoTheme {
                AppNavigation(navController = rememberNavController())
            }
        }
    }
}
