package com.example.meeteducation

import AppDatabaseStars
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.meeteducation.database.likes.LikeDao
import com.example.meeteducation.database.likes.likes
import com.example.meeteducation.databinding.FragmentInformationCourseBinding
import kotlinx.coroutines.launch

class InformationCourseFragment : Fragment() {

    private var _binding: FragmentInformationCourseBinding? = null

    private val binding get() = _binding!!

    private val databaseStars: AppDatabaseStars by lazy {
        AppDatabaseStars.getDatabase(requireActivity().baseContext)
    }

    private lateinit var likeDao: LikeDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        likeDao = databaseStars.likeDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInformationCourseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgLike.setOnClickListener{
            lifecycleScope.launch {
                val like = 1
                val likeToInsert = likes(0,like)
                binding.numLikes.text = likeDao.getLikesCount().toString()

            }
        }
        binding.imgDislike.setOnClickListener{
            lifecycleScope.launch {
                val like = 0
                val likeToInsert = likes(0,like)
                var dislikes = likeDao.getVotosCount() - likeDao.getLikesCount()
                binding.numDislikes.text = dislikes.toString()
            }
        }


    }

}