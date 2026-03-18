package com.ths.finance.services

import android.content.Context
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import com.ths.finance.data.Loan
import java.io.File

class PdfService {
    fun generateAgreement(context: Context, loan: Loan): File {
        val file = File(context.filesDir, "Agreement_${loan.loanId}.pdf")
        val writer = PdfWriter(file)
        val pdf = PdfDocument(writer)
        val document = Document(pdf)
        
        document.add(Paragraph("THS FINANCE - LOAN AGREEMENT").setBold().setFontSize(20f))
        document.add(Paragraph("Customer: ${loan.customerName}"))
        document.add(Paragraph("Aadhaar: ${loan.aadhaarNumber}"))
        document.add(Paragraph("Amount: ₹ ${loan.disbursedAmount}"))
        document.add(Paragraph("Total Collectable: ₹ ${loan.totalCollectable}"))
        document.add(Paragraph("Date: ${System.currentTimeMillis()}"))
        
        document.close()
        return file
    }
}
