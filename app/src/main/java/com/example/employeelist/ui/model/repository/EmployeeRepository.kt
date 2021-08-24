package com.example.employeelist.ui.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.employeelist.ui.model.models.Employee

object EmployeeRepository {

    private val employeeList = mutableListOf<Employee>()
    var employees = MutableLiveData<List<Employee>>()

    fun deleteEmployee(employee: Employee) {
        employeeList.remove(employee)
        employees.value = employeeList
    }

    fun addEmployee(employee: Employee) {
        employeeList.add(employee)
        employees.value = employeeList
    }
}