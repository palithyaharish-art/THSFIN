package com.ths.finance.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ths.finance.ui.theme.MintGreen

@Composable
fun DisbursementForm(navController: NavController) {
    var step by remember { mutableIntStateOf(1) }
    var customerName by remember { mutableStateOf("") }
    var aadhaar by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New Disbursement", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Step $step of 4", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = step / 4f,
                modifier = Modifier.fillMaxWidth(),
                color = MintGreen
            )
            Spacer(modifier = Modifier.height(24.dp))

            when (step) {
                1 -> StepIdentity(customerName, { customerName = it }, aadhaar, { aadhaar = it })
                2 -> StepLoanConfig(amount, { amount = it })
                3 -> StepMedia()
                4 -> StepReview(customerName, aadhaar, amount)
            }

            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                if (step > 1) {
                    Button(onClick = { step-- }) { Text("Back") }
                } else {
                    Spacer(modifier = Modifier.width(1.dp))
                }
                Button(
                    onClick = {
                        if (step < 4) step++
                        else {
                            // Submit Lead
                            navController.popBackStack()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MintGreen)
                ) {
                    Text(if (step == 4) "Submit Lead" else "Next")
                }
            }
        }
    }
}

@Composable
fun StepIdentity(name: String, onNameChange: (String) -> Unit, aadhaar: String, onAadhaarChange: (String) -> Unit) {
    Column {
        Text("Customer Identity", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = aadhaar,
            onValueChange = onAadhaarChange,
            label = { Text("Aadhaar Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("OCR Ghosting active... Point camera at Aadhaar card.", color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun StepLoanConfig(amount: String, onAmountChange: (String) -> Unit) {
    Column {
        Text("Loan Configuration", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = amount,
            onValueChange = onAmountChange,
            label = { Text("Net Disbursed Amount (₹)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Select Loan Type:", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            FilterChip(selected = true, onClick = {}, label = { Text("100-Day") })
            Spacer(modifier = Modifier.width(8.dp))
            FilterChip(selected = false, onClick = {}, label = { Text("Weekly") })
            Spacer(modifier = Modifier.width(8.dp))
            FilterChip(selected = false, onClick = {}, label = { Text("Monthly") })
        }
    }
}

@Composable
fun StepMedia() {
    Column {
        Text("Verification Media", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Capture Customer Photo") }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Capture House Photo") }
        Spacer(modifier = Modifier.height(16.dp))
        Text("GPS Location Locked: 17.3850° N, 78.4867° E", color = MintGreen, fontSize = 12.sp)
    }
}

@Composable
fun StepReview(name: String, aadhaar: String, amount: String) {
    Column {
        Text("Review & Submit", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Name: $name")
                Text("Aadhaar: $aadhaar")
                Text("Amount: ₹ $amount")
                Text("Type: 100-Day Daily")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Status: PENDING ACTIVATION", color = Color.Red, fontWeight = FontWeight.Bold)
            }
        }
    }
}
