package com.example.meeteducation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.databinding.FragmentInicioBinding


class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater,container,false)

        binding.btnLogin.setOnClickListener{
            findNavController().navigate(R.id.action_inicioFragment_to_loginFragment)
        }
        binding.signUp.setOnClickListener{
            findNavController().navigate(R.id.action_inicioFragment_to_registerStudentFragment)
        }
        return binding.root
    }




}