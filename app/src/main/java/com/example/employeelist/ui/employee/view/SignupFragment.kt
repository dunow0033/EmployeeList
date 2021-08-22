package com.example.employeelist.ui.employee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.employeelist.R
import com.example.employeelist.databinding.SignupFragmentBinding
import kotlin.concurrent.fixedRateTimer

class SignupFragment : Fragment() {
    private var _binding : SignupFragmentBinding? = null
    private val binding : SignupFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignupFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val employeeListFragment = EmployeeListFragment()
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

        binding.submitButton.setOnClickListener {
            transaction.replace(R.id.nav_host_fragment, employeeListFragment)
            transaction.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}