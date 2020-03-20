package br.com.soluevo.www.di

import br.com.soluevo.www.service.remote.photo.PhotoApiDataSource
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    single {
        val retrofit = get<Retrofit>()
        retrofit.create(PhotoApiDataSource::class.java)
    }

}