package br.com.soluevo.www.service.remote.photo

import br.com.soluevo.www.domain.Photo
import br.com.soluevo.www.service.utils.RemoteDataSourceClearJobs
import br.com.stant.obras.service.BaseRemoteDataSource

interface PhotoRemoteDataSource : RemoteDataSourceClearJobs {

    fun getPhotos(callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Photo>>)
}