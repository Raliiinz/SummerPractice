package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.summerpractice.databinding.FragmentPersonDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class PersonDetailFragment : Fragment(R.layout.fragment_person_detail) {

    private var binding: FragmentPersonDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPersonDetailBinding.bind(view)
        val personId = arguments?.getInt(PERSON_ID)
        if (personId != null) {
            val person = PersonRepository.persons.single {
                it.id == personId
            }
            setInfo(person)
        }

        binding?.btnGoToBack?.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    private fun setInfo(person: Person) {
        binding?.run {
            tvPersonId.text = "${getString(R.string.id)}${person.id}"
            tvPersonName.text = "${getString(R.string.name)} ${person.name}"
            tvPersonNumber.text = "${getString(R.string.number)} \n ${person.number}"
            tvInfotext.text = "${person.notes}"

            Glide.with(this@PersonDetailFragment)
                .load(person.url)
                .placeholder(R.drawable.baseline_image_not_supported_24)
                .error(R.drawable.baseline_error_outline_24)
                .apply(options)
                .into(icon)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        private const val PERSON_ID = "PERSON_ID"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(PERSON_ID, id)
            return bundle
        }
    }

}