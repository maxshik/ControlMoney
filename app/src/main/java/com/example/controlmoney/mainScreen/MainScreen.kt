package com.example.controlmoney.mainScreen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.controlmoney.addDebtScreen.AddDebtActivity

@Composable
fun MainScreen(modifier: Modifier, context: Context) {
    // TODO: Отрисовывать карточки с долгами тут

    Column(modifier) {
        Button(onClick = {
            val i = Intent(context, AddDebtActivity::class.java)
            context.startActivity(i)
        }) { Text("Добавить долг") }
    }
}