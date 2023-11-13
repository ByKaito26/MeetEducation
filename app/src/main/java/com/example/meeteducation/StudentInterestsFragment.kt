package com.example.meeteducation

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.database.AppDatabase
import com.example.meeteducation.database.user.UserDao
import com.example.meeteducation.databinding.FragmentStudentInterestsBinding


class StudentInterestsFragment : Fragment() {

    private var _binding: FragmentStudentInterestsBinding? = null

    private val  binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences
    private  lateinit var root: View

    private val database: AppDatabase by lazy {
        AppDatabase.getDatabase(requireActivity().baseContext)
    }
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userDao= database.UserDao()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentInterestsBinding.inflate(inflater, container, false)
        root = binding.root

        binding.Biology.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment_to_dashboardStudentFragment)
        }
        binding.Maths.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment_to_dashboardStudentFragment)
        }
        binding.Chemistry.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment_to_dashboardStudentFragment)
        }
        binding.History.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment_to_dashboardStudentFragment)
        }
        binding.Physics.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment_to_dashboardStudentFragment)
        }
        binding.Languages.setOnClickListener {
            findNavController().navigate(R.id.action_studentInterestsFragment_to_dashboardStudentFragment)
        }

        return root
    }

}