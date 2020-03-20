package br.com.soluevo.www.di

import br.com.soluevo.www.service.remote.photo.PhotoRemoteDataSource
import br.com.soluevo.www.service.remote.photo.PhotoRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {

    single<PhotoRemoteDataSource> {
        PhotoRemoteDataSourceImpl(get())
    }
}