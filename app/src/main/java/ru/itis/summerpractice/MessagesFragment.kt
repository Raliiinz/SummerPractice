package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment(R.layout.fragment_messages) {

    private var binding: FragmentMessagesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMessagesBinding.bind(view)
        binding?.run {
            btnSend.setOnClickListener {
                if (!etTextInput.text.isNullOrEmpty()) {
                    findNavController().navigate(
                        resId = R.id.action_messagesFragment_to_messagesTrueFragment,
                        args = MessagesTrueFragment.bundle(
                            text = etTextInput.text.toString()
                        )
                    )
                } else {
                    Snackbar.make(requireView(), "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}