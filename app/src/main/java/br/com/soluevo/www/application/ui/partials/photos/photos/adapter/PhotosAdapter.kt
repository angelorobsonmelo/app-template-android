package br.com.soluevo.www.application.ui.partials.photos.photos.adapter

import br.com.soluevo.www.R
import br.com.soluevo.www.application.util.BindingAdapter
import br.com.soluevo.www.databinding.PhotoItemBinding
import br.com.soluevo.www.domain.Photo

class PhotosAdapter(private val mPhotos: List<Photo>, private val onClick: (Photo) -> Unit) :
    BindingAdapter<PhotoItemBinding>() {

    override fun getItemCount(): Int = mPhotos.size

    override fun getLayoutResId(): Int = R.layout.photo_item

    override fun onBindViewHolder(binding: PhotoItemBinding, position: Int) {
        binding.run {
            val item = mPhotos[position]
            photo = item
            binding.ivPhoto.setOnClickListener {
                onClick.invoke(item)
            }
            executePendingBindings()
        }
    }

    fun updateItem(photos: List<Photo>) {
        notifyDataSetChanged()
    }
}