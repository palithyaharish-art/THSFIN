package com.ths.finance.services

import com.google.firebase.firestore.FirebaseFirestore
import com.ths.finance.data.Loan

class FirebaseService {
    private val db = FirebaseFirestore.getInstance()

    fun submitLead(loan: Loan, onComplete: (Boolean) -> Unit) {
        db.collection("leads")
            .document(loan.loanId)
            .set(loan)
            .addOnCompleteListener { onComplete(it.isSuccessful) }
    }

    fun activateLoan(loanId: String, onComplete: (Boolean) -> Unit) {
        db.collection("leads").document(loanId).get().addOnSuccessListener { snapshot ->
            val loan = snapshot.toObject(Loan::class.java)
            if (loan != null) {
                db.collection("active_loans").document(loanId).set(loan.copy(status = "ACTIVE"))
                    .addOnSuccessListener {
                        db.collection("leads").document(loanId).delete()
                        onComplete(true)
                    }
            }
        }
    }
}
