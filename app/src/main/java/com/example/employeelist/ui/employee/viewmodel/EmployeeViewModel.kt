package com.example.employeelist.ui.employee.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.employeelist.ui.model.models.Employee
import com.example.employeelist.ui.model.repository.EmployeeRepoImp
import com.example.employeelist.ui.model.repository.EmployeeRepository
import java.lang.IllegalArgumentException

class EmployeeViewModel(private val repo : EmployeeRepository) : ViewModel() {

    val employees: LiveData<List<Employee>> = EmployeeRepository.employees

    fun addEmployee(employee: Employee) {
        EmployeeRepository.addEmployee(employee)
    }

    fun deleteEmployee(employee: Employee) {
        EmployeeRepository.deleteEmployee(employee)
    }

    class Factory(private val repo : EmployeeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
                return EmployeeViewModel(repo) as T
            } else {
                throw IllegalArgumentException("Cannot create instance of view model.")
            }
        }
    }
}