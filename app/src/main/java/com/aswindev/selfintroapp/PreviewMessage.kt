package com.aswindev.selfintroapp

import java.io.Serializable

data class PreviewMessage(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    // can be null
    val jobTitle: String?,
    val immediateStart: Boolean,
    // can be null
    val startDate: String?
) : Serializable {
    fun getFullJObDescription(): String =

        if (includeJunior) "a Junior $jobTitle" else "an $jobTitle"

    fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"
}
