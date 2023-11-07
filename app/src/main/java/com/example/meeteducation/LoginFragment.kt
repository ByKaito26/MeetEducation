package com.example.meeteducation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.database.AppDatabase
import com.example.meeteducation.database.user.UserDao
import com.example.meeteducation.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var root: View

    private val database: AppDatabase by lazy{
        AppDatabase.getDatabase(requireActivity().baseContext)
    }

    private lateinit var userDao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create the userDao from Database
        userDao = database.UserDao()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)

        sharedPreferences = requireActivity().getSharedPreferences(
            "MyAppPreferences", Context.MODE_PRIVATE
        )
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_inicioFragment)
        }
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerStudentFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to Dashboard Fragment with Safe Args
        binding.btnLogin.setOnClickListener {
            // Edit the sharedPreferences file with the user
            val editor = sharedPreferences.edit()
            lifecycleScope.launch {
                // Catch the user and password from the UI and search in the database
                val user = userDao.getUserById(
                    binding.edEmailAddress?.text.toString(),
                    binding.edPassword?.text.toString()
                )
                // Check if the user exist
                if (user != null) {
                    //println("user: ${user.user} and password: ${user.password}")
                    editor?.putString("user", user.user)
                    editor?.apply()
                    // Navigate
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToDahboardFragment())
                }else {
                    Snackbar.make(view, R.string.ini_error_user_password, Snackbar.LENGTH_SHORT).show()
                }

            }
        }
    }


}