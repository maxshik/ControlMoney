package com.example.controlmoney.mainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.controlmoney.ui.theme.ControlMoneyTheme

class MainActivity : ComponentActivity() {


    // Приложение для отслеживания кто тебе сколько денег должен
    // Два экрана: список долгов и добавление долга
    // Хранение долгов будет в JSON файле
    // Надо реализовать уведомление о том, что человек должен вернуть долг (через дату)
    // Уведомления сделаем вместе



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControlMoneyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(Modifier.padding(innerPadding), this)
                }
            }
        }
    }
}

