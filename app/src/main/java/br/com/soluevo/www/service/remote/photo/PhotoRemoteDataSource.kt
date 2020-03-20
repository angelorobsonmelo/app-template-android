package br.com.soluevo.www.service.remote.photo

import br.com.soluevo.www.domain.Photo
import br.com.stant.obras.service.BaseRemoteDataSource

interface PhotoRemoteDataSource {

    fun getPhotos(callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Photo>>)
}