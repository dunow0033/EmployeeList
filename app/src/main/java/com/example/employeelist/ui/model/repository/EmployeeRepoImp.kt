package com.example.employeelist.ui.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.employeelist.ui.model.models.Employee

object EmployeeRepoImp {
    private val employee1 = Employee("Dan Smith", "32", "Engineer", "873-758-8732")
    private val employee2 = Employee("Tom Jones", "33", "Plumber", "823-924-4392")
    private val employee3 = Employee("Jack Richmond", "63", "Waiter", "823-873-0012")
    private val employee4 = Employee("Sam Thompson", "43", "Analyst", "459-398-0145")

    private val employeeList = mutableListOf(employee1, employee2, employee3, employee4)
    val employees: MutableLiveData<List<Employee>> = MutableLiveData(employeeList)

    fun deleteEmployee(employee: Employee) {
        employeeList.remove(employee)
        employees.value = employeeList
    }

    fun addEmployee(employee: Employee) {
        employeeList.add(employee)
        employees.value = employeeList
    }
}