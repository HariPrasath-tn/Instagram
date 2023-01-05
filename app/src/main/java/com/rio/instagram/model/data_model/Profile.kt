package com.rio.instagram.model.data_model

data class Profile(
    val account_type: String,
    val contact: String,
    val dob: String,
    val dp: String,
    val firstname: String,
    val lastname: String,
    val mail: String,
    val password: String,
    val security_answer: String,
    val security_question: String,
    val description: String,
    val username: String
)