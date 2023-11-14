/**
 * Fragmento que representa el panel de control principal.
 */
package com.example.meeteducation

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.meeteducation.database.AppDatabase
import com.example.meeteducation.database.user.UserDao
import com.example.meeteducation.databinding.FragmentDahboardBinding
import com.google.android.material.appbar.MaterialToolbar

/**
 * Clase que extiende Fragment y representa el panel de control principal.
 */
class DahboardFragment : Fragment() {

    private var _binding: FragmentDahboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var root: View
    private lateinit var drawerLayout: DrawerLayout

    val args: DahboardFragmentArgs by navArgs()

    private val database: AppDatabase by lazy {
        AppDatabase.getDatabase(requireActivity().baseContext)
    }

    private lateinit var userDao: UserDao

    /**
     * Método llamado cuando se crea el fragmento.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userDao = database.UserDao()
    }

    /**
     * Método llamado para crear la vista del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDahboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Método llamado después de que la vista ha sido creada.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del listener para el botón de retroceso
        setupBackPressListener()

        val sharedPreferences = context?.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val user = sharedPreferences?.getString("user", "Desconocido")

        // Actualiza el texto del nombre de usuario en la vista
        binding.txtNombreUsuario.text = user

        // Configuración de los botones en el fragmento
        binding.uploadTextView.setOnClickListener {
            findNavController().navigate(R.id.action_dahboardFragment_to_uploadDashboardTeacherFragment)
        }
        binding.MathClass2Teacher.setOnClickListener {
            findNavController().navigate(R.id.action_dahboardFragment_to_informationCourseFragment)
        }
    }

    /**
     * Método para configurar el listener para el botón de retroceso.
     */
    private fun setupBackPressListener() {
        this.view?.isFocusableInTouchMode = true
        this.view?.requestFocus()
        this.view?.setOnKeyListener { _, keyCode, _ ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }

    /**
     * Método llamado cuando el fragmento es destruido.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
