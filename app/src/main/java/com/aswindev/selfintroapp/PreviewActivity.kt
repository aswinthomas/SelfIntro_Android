package com.aswindev.selfintroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aswindev.selfintroapp.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val contactName = intent.getStringExtra("Contact Name")
        val contactNumber = intent.getStringExtra("Contact Number")
        val displayName = intent.getStringExtra("Display Name")
        val includeJunior = intent.getBooleanExtra("Include Junior", false)
        val jobTitle = intent.getStringExtra("Job Title")
        val immediateStart = intent.getBooleanExtra("Immediate Start", false)
        val startDate = intent.getStringExtra("Start Date")

        val testString =
            "Name: $contactName, Num: $contactNumber, Display Name: $displayName, Junior: $includeJunior, Title: $jobTitle, Immediate Start: $immediateStart, Start Date: $startDate"
        binding.textViewMessage.text = testString

    }
}