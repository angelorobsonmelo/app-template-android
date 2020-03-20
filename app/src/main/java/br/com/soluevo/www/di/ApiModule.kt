package br.com.soluevo.www.di

import br.com.soluevo.www.service.remote.photo.PhotoApiDataSource
import org.koin.dsl.module

val apiModule = module {

    single { createApi<PhotoApiDataSource>(get()) }

}