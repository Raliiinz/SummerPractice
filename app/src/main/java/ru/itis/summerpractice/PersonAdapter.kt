package ru.itis.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice.databinding.ItemCityBinding

class CityAdapter(
    private var list: List<Person>,
    private val glide: RequestManager,
    private val onClick: (Person) -> Unit,
) : RecyclerView.Adapter<CityHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityHolder = CityHolder(
        binding = ItemCityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataset(newList: List<Person>) {
        list = newList
        notifyDataSetChanged()
    }
}