package br.com.soluevo.www.di

import br.com.soluevo.www.application.ui.partials.photos.photos.PhotosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModuleModule = module {

    viewModel {
        PhotosViewModel(get())
    }
}