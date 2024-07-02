package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.summerpractice.databinding.FragmentCallsBinding
import ru.itis.summerpractice.utils.showSnackbar

class CallsFragment : Fragment(R.layout.fragment_calls) {

    private var binding: FragmentCallsBinding? = null

    private var adapter: PersonAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCallsBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = PersonAdapter(
                list = PersonRepository.persons,
                glide = Glide.with(this@CallsFragment),
                onClick = { person ->
                    findNavController().navigate(
                        R.id.action_callsFragment_to_momDetailFragment,
                        PersonDetailFragment.createBundle(person.id)
                    )
                    binding?.root?.showSnackbar(person.name)
                }

            )

            binding?.rvPerson?.adapter = adapter

//          по-умолчанию линерлайоутманагер строит вертикальный список
            rvPerson.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}