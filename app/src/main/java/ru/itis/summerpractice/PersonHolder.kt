package ru.itis.summerpractice

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.itis.summerpractice.databinding.ItemPersonBinding

class PersonHolder(
    private val binding: ItemPersonBinding,
    private val glide: RequestManager,
    private val onClick: (Person) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    fun onBind(person: Person) {
        binding.run {
            tvName.text = person.name
            tvNumber.text = person.number

            glide
                .load(person.url)
                .error(R.drawable.img_not_found)
                .placeholder(R.drawable.img_cat)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(person)
            }
        }
    }

}