package com.example.madlevel7example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(activity as AppCompatActivity).get(QuizViewModel::class.java)

        btnCreateQuestion.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_createQuizFragment) }
        btnStartQuiz.setOnClickListener {
            if (viewModel.isQuestionCreated()) {
                findNavController().navigate(R.id.action_homeFragment_to_quizFragment)
            } else {
                Toast.makeText(
                    context,
                    "Please create a question before starting the quiz.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
