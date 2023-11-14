/**
 * Fragmento que representa el panel de control del estudiante.
 */
package com.example.meeteducation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meeteducation.databinding.FragmentDashboardStudentBinding
import com.google.android.material.navigation.NavigationView

/**
 * Clase que extiende Fragment y representa el panel de control del estudiante.
 */
class DashboardStudentFragment : Fragment() {

    private var _binding: FragmentDashboardStudentBinding? = null
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    private val binding get() = _binding!!

    /**
     * Método llamado para crear la vista del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardStudentBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Método llamado después de que la vista ha sido creada.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del comportamiento del botón en el fragmento
        binding.MathClass2.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardStudentFragment_to_informationCourseFragment)
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
