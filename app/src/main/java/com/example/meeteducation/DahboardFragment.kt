package com.example.meeteducation

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.meeteducation.databinding.FragmentDahboardBinding

class DahboardFragment : Fragment() {

    private var _binding: FragmentDahboardBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var root: View

    val args: DahboardFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDahboardBinding.inflate(inflater, container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBackPressListener()
        val sharedPreferences = context?.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val user = sharedPreferences?.getString("user", "Desconocido")

        binding.txtNombreUsuario.text = user

        binding.uploadTextView.setOnClickListener {
            findNavController().navigate(R.id.action_dahboardFragment_to_uploadDashboardTeacherFragment)
        }
        binding.MathClass2Teacher.setOnClickListener {
            findNavController().navigate(R.id.action_dahboardFragment_to_informationCourseFragment)
        }

    }

    private fun setupBackPressListener() {
        this.view?.isFocusableInTouchMode = true
        this.view?.requestFocus()
        this.view?.setOnKeyListener { _, keyCode, _ ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }


}