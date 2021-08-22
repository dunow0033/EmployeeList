package com.example.employeelist.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelist.databinding.EmployeeContactFragmentBinding
import com.example.employeelist.ui.model.models.Employee

class EmployeeAdapter (
    private val employeeList: List<Employee>,
    private val listener: (employee: Employee) -> Unit,
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    private var listOfEmployees = emptyList<Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EmployeeContactFragmentBinding.inflate(inflater, parent, false)
        return EmployeeViewHolder(binding).also { holder ->
            holder.itemView.setOnClickListener {
                listener.invoke(employeeList[holder.adapterPosition])
            }
        }
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    class EmployeeViewHolder(private val binding: EmployeeContactFragmentBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(employee: Employee){
                    with(binding) {
                        nameTv.text = employee.name
                        occupationTv.text = employee.job
                        phoneNumberTv.text = employee.phone_number
                        ageTv.text = employee.age
                    }
                }
            }
}