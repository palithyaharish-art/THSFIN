package com.ths.finance.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerScheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ths.finance.data.Loan
import com.ths.finance.ui.theme.MintGreen

@Composable
fun AgentDashboard(navController: NavController) {
    var loans by remember { mutableStateOf(listOf(
        Loan("1", "John Doe", "123456789012", 10000.0, 12000.0, 80, 0.0, 0.0, 0.0, "ACTIVE", "agent1", null),
        Loan("2", "Jane Smith", "987654321098", 5000.0, 6000.0, 10, 120.0, 0.0, 0.0, "ACTIVE", "agent1", null)
    )) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agent Dashboard", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("disbursement_form") },
                containerColor = MintGreen
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Loan")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            TargetCard()
            Spacer(modifier = Modifier.height(16.dp))
            Text("Today's Collections", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(loans) { loan ->
                    IsometricLoanCard(loan)
                }
            }
        }
    }
}

@Composable
fun TargetCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .graphicsLayer {
                rotationX = 10f
                rotationY = -10f
                cameraDistance = 12f * density
            },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Today's Target", color = Color.White.copy(alpha = 0.7f), fontSize = 14.sp)
            Text("₹ 15,000", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = 0.6f,
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = MintGreen,
                trackColor = Color.White.copy(alpha = 0.3f)
            )
        }
    }
}

@Composable
fun IsometricLoanCard(loan: Loan) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .graphicsLayer {
                rotationX = 5f
                rotationY = -5f
                cameraDistance = 12f * density
            }
            .clickable { /* Show Details */ },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(loan.customerName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text("Arrears: ₹ ${loan.arrears}", color = if (loan.arrears > 0) Color.Red else Color.Gray, fontSize = 12.sp)
            }
            Text("₹ ${loan.totalCollectable / 100}", color = MintGreen, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}
