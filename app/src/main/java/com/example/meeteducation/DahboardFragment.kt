package com.example.meeteducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import com.example.meeteducation.database.AppDatabase
import com.example.meeteducation.database.user.UserDao
import com.example.meeteducation.databinding.FragmentDahboardBinding
import kotlinx.coroutines.launch

class DahboardFragment : Fragment() {

    private var _binding: FragmentDahboardBinding? = null
    private lateinit var drawer: DrawerLayout
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
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
        _binding = FragmentDahboardBinding.inflate(inflater, container,false)
        lifecycleScope.launch {
            val users = userDao.getAll()
            for (user in users) {
                println("${user.id}. ${user.email}, ${user.rol}, ${user.password}, ${user.user}")
            }
        }
        /*drawer = requireActivity().findViewById(R.id.drawer_navigation)
        drawer.isVisible = true*/

        return binding.root
    }


}