package com.example.jokitugas

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val editTextBase: EditText = findViewById(R.id.editTextBase)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val base = editTextBase.text.toString().toDoubleOrNull()
            val height = editTextHeight.text.toString().toDoubleOrNull()

            if (base != null && height != null) {
                val prismProperties = calculatePrismProperties(base, height)
                textViewResult.text = prismProperties
            } else {
                textViewResult.text = "Masukkan panjang alas dan tinggi segitiga yang valid."
            }
        }
    }

    private fun calculatePrismProperties(base: Double, height: Double): String {
        val triangularArea = 0.5 * base * height
        val triangularPerimeter = base * 3

        val prismArea = 3 * triangularArea // Prisma segitiga memiliki 3 sisi segitiga yang identik.
        val prismPerimeter = 3 * triangularPerimeter

        return "Luas Prisma Segitiga: $prismArea \nKeliling Prisma Segitiga: $prismPerimeter"
    }
}
