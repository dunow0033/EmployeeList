package com.example.employeelist.ui.employee.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.employeelist.ui.model.models.Employee
import com.example.employeelist.ui.model.repository.EmployeeRepoImp

class EmployeeViewModel : ViewModel() {

    val employees: LiveData<List<Employee>> = EmployeeRepoImp.employees

    fun addEmployee(employee: Employee) {
        EmployeeRepoImp.addEmployee(employee)
    }

    fun deleteEmployee(employee: Employee) {
        EmployeeRepoImp.deleteEmployee(employee)
    }

}