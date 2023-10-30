package com.example.meeteducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)

        binding.btnStudent.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_registerStudentFragment)
        }
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_inicioFragment)
        }

        return binding.root
    }

}