package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice.databinding.FragmentMomDetailBinding
import com.bumptech.glide.Glide

class MomDetailFragment : Fragment(R.layout.fragment_mom_detail) {

    private var binding: FragmentMomDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMomDetailBinding.bind(view)
        //val bundle = arguments?.bundle<String>()
        val name = arguments?.getString(ARG_NAME)?: "ERROR"
        val number = arguments?.getString(ARG_NUMBER)?: "N/A"
        val image = arguments?.getString(ARG_IMAGE)?: "default_image.png" // Замените на путь к вашему значению по умолчанию
        val email = arguments?.getString(ARG_NAME) ?: "ERROR"

        binding?.run {
            tvTitle.text = "$name ($number)"
            // Предполагаем, что у вас есть ImageView для отображения изображения
            binding?.ivImage.load(image)

//            ivImage.load(image)
//         //tvTitle.text = "${tvTitle.text} $email "


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {

        private const val ARG_NAME = "ARG_TEXT"
        private const val ARG_NUMBER = "ARG_NUMBER"
        private const val ARG_IMAGE = "ARG_IMAGE"

        fun bundle(text: String, number: String, image: String): Bundle = Bundle().apply {
            putString(ARG_NAME, text)
            putString(ARG_NUMBER, number)
            putString(ARG_IMAGE, image)

        }
    }

}