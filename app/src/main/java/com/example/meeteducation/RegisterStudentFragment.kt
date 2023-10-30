package com.example.meeteducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.databinding.FragmentRegisterStudentBinding

class RegisterStudentFragment : Fragment() {

    private var _binding: FragmentRegisterStudentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterStudentBinding.inflate(inflater,container,false)

        binding.btnTeacher.setOnClickListener {
            findNavController().navigate(R.id.action_registerStudentFragment_to_registerFragment)
        }
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_registerStudentFragment_to_inicioFragment)
        }


        return binding.root
    }

}