package com.ths.finance.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
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
import com.ths.finance.ui.theme.ElectricIndigo
import com.ths.finance.ui.theme.MintGreen

@Composable
fun OwnerDashboard(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Owner Dashboard", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { /* Settings */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            PortfolioHealthCard()
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                CollectionModeCard("Cash", "₹ 45,000", Modifier.weight(1f))
                Spacer(modifier = Modifier.width(16.dp))
                CollectionModeCard("UPI", "₹ 82,000", Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text("Agent Performance", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            AgentList()
        }
    }
}

@Composable
fun PortfolioHealthCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .graphicsLayer {
                rotationX = 10f
                rotationY = 5f
                cameraDistance = 12f * density
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text("Total Portfolio Value", color = Color.Gray, fontSize = 14.sp)
            Text("₹ 12,45,000", color = ElectricIndigo, fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Active Loans: 156", color = Color.Gray, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Text("Collection: 88%", color = MintGreen, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CollectionModeCard(mode: String, amount: String, modifier: Modifier) {
    Card(
        modifier = modifier.height(100.dp),
        colors = CardDefaults.cardColors(containerColor = if (mode == "Cash") Color(0xFFE3F2FD) else Color(0xFFF1F8E9)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.Center) {
            Text(mode, color = Color.Gray, fontSize = 12.sp)
            Text(amount, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun AgentList() {
    val agents = listOf("Agent Harish", "Agent Rahul", "Agent Suresh")
    LazyColumn {
        items(agents) { agent ->
            ListItem(
                headlineContent = { Text(agent) },
                supportingContent = { Text("Collected Today: ₹ 12,000") },
                leadingContent = { Icon(Icons.Default.Person, contentDescription = null) },
                trailingContent = { Text("92%", color = MintGreen, fontWeight = FontWeight.Bold) }
            )
            HorizontalDivider()
        }
    }
}
