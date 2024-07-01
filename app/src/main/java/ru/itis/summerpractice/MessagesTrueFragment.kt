package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice.databinding.FragmentMessagesTrueBinding

class MessagesTrueFragment : Fragment(R.layout.fragment_messages_true) {

    private var binding: FragmentMessagesTrueBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMessagesTrueBinding.bind(view)
        val email = arguments?.getString(ARG_TEXT) ?: "ERROR"

        binding?.run {
            tvTitle.text = "${tvTitle.text} $email"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {

        private const val ARG_TEXT = "ARG_TEXT"

        fun bundle(text: String): Bundle = Bundle().apply {
            putString(ARG_TEXT, text)

        }
    }
}