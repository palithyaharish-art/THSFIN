package com.ths.finance.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loans")
data class Loan(
    @PrimaryKey val loanId: String = "",
    val customerName: String = "",
    val aadhaarNumber: String = "",
    val disbursedAmount: Double = 0.0,
    val totalCollectable: Double = 0.0,
    val remainingInstallments: Int = 0,
    val arrears: Double = 0.0,
    val locationLat: Double = 0.0,
    val locationLng: Double = 0.0,
    val status: String = "LEAD", // LEAD, ACTIVE, CLOSED
    val agentId: String = "",
    val paymentMode: String? = null // CASH, UPI
)
