package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice.databinding.FragmentSettingsBinding
import ru.itis.summerpractice.utils.showSnackbar

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}