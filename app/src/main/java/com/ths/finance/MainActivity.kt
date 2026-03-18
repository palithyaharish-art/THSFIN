package com.ths.finance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ths.finance.ui.screens.AgentDashboard
import com.ths.finance.ui.screens.DisbursementForm
import com.ths.finance.ui.screens.OwnerDashboard
import com.ths.finance.ui.theme.THSFinanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            THSFinanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "agent_dashboard") {
        composable("agent_dashboard") { AgentDashboard(navController) }
        composable("owner_dashboard") { OwnerDashboard(navController) }
        composable("disbursement_form") { DisbursementForm(navController) }
    }
}
