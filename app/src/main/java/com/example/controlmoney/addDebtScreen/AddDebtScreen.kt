package com.example.controlmoney.addDebtScreen

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.controlmoney.viewModels.DebtViewModel
import java.util.Calendar

@Composable
fun AddDebtScreen(modifier: Modifier = Modifier, viewModelDebt: DebtViewModel, localActivity: Activity?) {
    var friendName by remember { mutableStateOf("") }
    var debtAmount by remember { mutableStateOf("") }
    var debtDate by remember { mutableStateOf("") }
    var returnDate by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    val context = LocalContext.current

    fun openDatePicker(isDebtDate: Boolean) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(context, { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate = "${selectedDay.toString().padStart(2, '0')}.${
                (selectedMonth + 1).toString().padStart(2, '0')
            }.$selectedYear"
            if (isDebtDate) {
                debtDate = formattedDate
            } else {
                returnDate = formattedDate
            }
        }, year, month, day)

        datePicker.show()
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Добавить долг", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = friendName,
            onValueChange = { friendName = it },
            label = { Text("Имя друга") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = debtDate,
            onValueChange = {},
            label = { Text("Дата долга (ДД.ММ.ГГГГ)") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { openDatePicker(true) }) {
                    Icon(Icons.Default.DateRange, contentDescription = "Выбрать дату")
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = returnDate,
            onValueChange = {},
            label = { Text("Дата возврата (ДД.ММ.ГГГГ)") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { openDatePicker(false) }) {
                    Icon(Icons.Default.DateRange, contentDescription = "Выбрать дату")
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = debtAmount,
            onValueChange = { debtAmount = it },
            label = { Text("Сумма") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = comment,
            onValueChange = { comment = it },
            label = { Text("Комментарий") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (viewModelDebt.addDebt(context, friendName, debtAmount, debtDate, returnDate, comment)) {
                    Toast.makeText(context, "Долг успешно добавлен", Toast.LENGTH_SHORT).show()
                    localActivity!!.finish()
                } else {
                    Toast.makeText(context, "Ошибка при добавлении долга", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Сохранить долг")
        }
    }
}