package br.com.soluevo.www.application.ui.partials.photos.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.soluevo.www.R
import br.com.soluevo.www.application.ui.partials.photos.photos.adapter.PhotosAdapter
import br.com.soluevo.www.application.util.BindingFragment
import br.com.soluevo.www.application.util.EventObserver
import br.com.soluevo.www.databinding.PhotosFragmentBinding
import br.com.soluevo.www.domain.Photo
import org.koin.androidx.viewmodel.ext.android.viewModel


class PhotosFragment : BindingFragment<PhotosFragmentBinding>() {

    private val viewModel by viewModel<PhotosViewModel>()

    override fun getLayoutResId(): Int = R.layout.photos_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getPosts()

        viewModel.successObserver.observe(viewLifecycleOwner, EventObserver {
            setupRecyclerView(it)
        })

        viewModel.errorObserver.observe(viewLifecycleOwner, EventObserver {
            print(it)
        })

        viewModel.isLoadingEventObserver.observe(viewLifecycleOwner, EventObserver {

        })
    }

    private fun setupRecyclerView(it: List<Photo>) {
        with(binding.recyclerView) {
            adapter = PhotosAdapter(it) {

            }

            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}
