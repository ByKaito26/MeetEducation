/**
 * Fragmento que muestra información sobre un curso.
 */
package com.example.meeteducation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.meeteducation.database.AppDatabase
import com.example.meeteducation.database.user.UserDao
import com.example.meeteducation.databinding.FragmentInformationCourseBinding
import kotlinx.coroutines.launch

/**
 * Clase que extiende Fragment y muestra información sobre un curso.
 */
class InformationCourseFragment : Fragment() {

    private var _binding: FragmentInformationCourseBinding? = null
    private val binding get() = _binding!!

    private lateinit var root: View

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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInformationCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Método llamado después de que la vista ha sido creada.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Implementación del fragmento, puedes añadir más lógica aquí según sea necesario.
    }

    /**
     * Método llamado cuando el fragmento es destruido.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
