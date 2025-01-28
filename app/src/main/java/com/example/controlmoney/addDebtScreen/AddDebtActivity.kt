package com.example.controlmoney.addDebtScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.controlmoney.ui.theme.ControlMoneyTheme
import com.example.controlmoney.viewModels.DebtViewModel

class AddDebtActivity : ComponentActivity() {
    private val viewModelDebt: DebtViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControlMoneyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AddDebtScreen(Modifier.padding(innerPadding), viewModelDebt, LocalActivity.current)
                }
            }
        }
    }
}