package com.example.meeteducation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.database.AppDatabase
import com.example.meeteducation.database.user.User
import com.example.meeteducation.database.user.UserDao
import com.example.meeteducation.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val database: AppDatabase by lazy{
        AppDatabase.getDatabase(requireActivity().baseContext)
    }

    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userDao = database.UserDao()
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Catch the UI EditText data and insert a new user in the database
        binding.btnRegister.setOnClickListener {
            lifecycleScope.launch{
                val name = binding.etName?.text.toString().trim()
                val email = binding.editTextTextEmailAddress.text.toString().trim()
                val user = binding.etUsuario.text.toString().trim()
                val password = binding.editTextTextPassword.text.toString().trim()
                val rol = "Teacher"

                when {
                    name.isNullOrEmpty() -> showToast("El nombre es nulo o vacío")
                    email.isNullOrEmpty() -> showToast("El email es nulo o vacío")
                    user.isNullOrEmpty() -> showToast("El usuario es nulo o vacío")
                    password.isNullOrEmpty() -> showToast("La contraseña está vacía")
                    else -> {
                        val userToInsert = User(0, name, email, user, password, rol)
                        userDao.insertUser(userToInsert)

                        // Snack bar to see the user added successfully
                        Snackbar.make(view, "Usuario registrado exitosamente.", Snackbar.LENGTH_SHORT).show()
                        clearFields()
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun clearFields(){
        //Clear all the EditText
        binding.etUsuario.editableText?.clear()
        binding.editTextTextEmailAddress.editableText?.clear()
        binding.editTextTextPassword.editableText?.clear()
        binding.etName.editableText?.clear()

        binding.container.requestFocus()
    }

}