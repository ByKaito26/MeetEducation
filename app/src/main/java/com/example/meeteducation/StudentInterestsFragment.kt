package com.example.meeteducation

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.databinding.FragmentStudentInterestsBinding


class StudentInterestsFragment : Fragment() {

    private var _binding: FragmentStudentInterestsBinding? = null

    private val binding get() = _binding!!
    private lateinit var root: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentInterestsBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBackPressListener()
        binding.History.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment3_to_dashboardStudentFragment)
        }
        binding.Maths.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment3_to_dashboardStudentFragment)
        }
        binding.Biology.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment3_to_dashboardStudentFragment)
        }
        binding.Languages.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment3_to_dashboardStudentFragment)
        }
        binding.Physics.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment3_to_dashboardStudentFragment)
        }
        binding.Chemistry.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment3_to_dashboardStudentFragment)
        }
        binding.backInterests.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment3_to_dashboardStudentFragment)
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