package com.example.controlmoney.models

data class Debt(
    val friendName: String,
    val debtAmount: String,
    val debtDate: String,
    val returnDate: String,
    val comment: String?
)