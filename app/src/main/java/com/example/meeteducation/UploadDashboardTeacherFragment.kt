package com.example.meeteducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.databinding.FragmentUploadDashboardTeacherBinding


class UploadDashboardTeacherFragment : Fragment() {

    private var _binding: FragmentUploadDashboardTeacherBinding? = null

    private val binding get() = _binding!!
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUploadDashboardTeacherBinding.inflate(inflater, container, false)

        binding.txtBegin.setOnClickListener {
            findNavController().navigate(R.id.action_uploadDashboardTeacherFragment_to_dahboardFragment)
        }


        return binding.root
    }

}