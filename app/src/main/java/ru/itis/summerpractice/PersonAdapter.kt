package ru.itis.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice.databinding.ItemPersonBinding

class PersonAdapter(
    private var list: List<Person>,
    private val glide: RequestManager,
    private val onClick: (Person) -> Unit,
) : RecyclerView.Adapter<PersonHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonHolder = PersonHolder(
        binding = ItemPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}