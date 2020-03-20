package br.com.soluevo.www.usecases.remote.photos

import br.com.soluevo.www.service.remote.photo.PhotoRemoteDataSource

class ClearJobsUseCase(private val photoRemoteDataSource: PhotoRemoteDataSource) {

    fun clearJobs() {
        photoRemoteDataSource.clearJobs()
    }
}