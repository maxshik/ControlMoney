package com.example.controlmoney.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.controlmoney.models.Debt
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileWriter
import java.io.IOException

class DebtViewModel : ViewModel() {
    fun addDebt(
        context: Context,
        friendName: String,
        debtAmount: String,
        debtDate: String,
        returnDate: String,
        comment: String?
    ) : Boolean {
        val newDebt = Debt(friendName, debtAmount, debtDate, returnDate, comment)

        val file = File(context.filesDir, "debts.json")

        val debtsList: MutableList<Debt> = if (file.exists()) {
            val json = file.readText()
            Gson().fromJson(json, object : TypeToken<MutableList<Debt>>() {}.type) ?: mutableListOf()
        } else {
            mutableListOf()
        }

        debtsList.add(newDebt)

        val json = Gson().toJson(debtsList)

        try {
            FileWriter(file).use { writer ->
                writer.write(json)
                return true
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
    }

    fun deleteDebt(debt: Debt) {
        // TODO: Реализовать удаление элемента
    }

    fun fetchDataFromFile() : MutableList<Debt> {
        // TODO: Реализовать получение данных из файла

        return mutableListOf()
    }
}