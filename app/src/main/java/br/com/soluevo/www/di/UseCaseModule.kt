package br.com.soluevo.www.di

import br.com.soluevo.www.usecases.remote.photos.GetPhotosUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single {
        GetPhotosUseCase(get())
    }
}