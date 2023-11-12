package com.example.meeteducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.databinding.FragmentDashboardStudentBinding


class DashboardStudentFragment : Fragment() {

    private var _binding: FragmentDashboardStudentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardStudentBinding.inflate(inflater, container, false)

        binding.MathClass2.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardStudentFragment_to_informationCourseFragment)
        }

        return binding.root
    }

}