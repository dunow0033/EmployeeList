package com.example.employeelist.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelist.R
import com.example.employeelist.databinding.EmployeeContactFragmentBinding
import com.example.employeelist.ui.model.models.Employee

class EmployeeAdapter (
    private val employeeList: List<Employee>,
    private val listener: (employee: Employee) -> Unit,
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    private var employees = mutableListOf<Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            EmployeeContactFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).also { employeeViewHolder ->
            employeeViewHolder.itemView.setOnClickListener{
                listener.invoke(employeeList[employeeViewHolder.adapterPosition])
            }
        }

//        val inflater = LayoutInflater.from(parent.context)
//        val binding = EmployeeContactFragmentBinding.inflate(inflater, parent, false)
//        return EmployeeViewHolder(binding).also { holder ->
//            holder.itemView.setOnClickListener {
//                listener.invoke(employeeList[holder.adapterPosition])
//            }
//        }
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun setData(employees: List<Employee>){
        this.employees.clear()
        this.employees.addAll(employees)
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(private val binding: EmployeeContactFragmentBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(employee: Employee){
                    with(binding) {
                        name.text = employee.name
                        occupation.text = employee.job
                        phoneNumber.text = employee.phone_number
                        age.text = employee.age
                    }
                }
            }
}