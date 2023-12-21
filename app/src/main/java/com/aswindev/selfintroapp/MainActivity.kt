package com.aswindev.selfintroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.aswindev.selfintroapp.databinding.ActivityMainBinding
import com.aswindev.selfintroapp.databinding.ActivityPreviewBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Engineer", "Technician", "Recruiter", "Engineering Manager")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
        val contactName = binding.editTextContactName.text.toString()
        val contactNumber = binding.editTextContactNumber.text.toString()
        val displayName = binding.editTextMyDisplayName.text.toString()
        val includeJunior = binding.checkBoxJunior.isChecked
        // kotlin does not know the following can be null, hence use '?'
        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()
        val immediateStart = binding.checkBoxImmediateStart.isChecked
        val startDate = binding.editTextStartDate.text.toString()
        Log.d("This is my Log tag", "Currently contactNameEditText is: $contactName")
        val testString =
            "Name: $contactName, Num: $contactNumber, Display Name: $displayName, Junior: $includeJunior, Title: $jobTitle, Immediate Start: $immediateStart, Start Date: $startDate"
        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("Contact Number", contactNumber)
        previewActivityIntent.putExtra("Display Name", displayName)
        previewActivityIntent.putExtra("Include Junior", includeJunior)
        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Immediate Start", immediateStart)
        previewActivityIntent.putExtra("Start Date", startDate)

        startActivity(previewActivityIntent)
    }
}