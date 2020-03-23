package br.com.soluevo.www.usecases.remote.photos


import br.com.soluevo.www.domain.Photo
import br.com.soluevo.www.service.remote.photo.PhotoRemoteDataSource
import br.com.soluevo.www.service.utils.UseCaseBaseCallback
import br.com.stant.obras.service.BaseRemoteDataSource


class GetPhotosUseCase(private val photoRemoteDataSource: PhotoRemoteDataSource) {

     fun getPosts(callback: UseCaseBaseCallback.UseCaseCallback<List<Photo>>) {
        photoRemoteDataSource.getPhotos(object :
            BaseRemoteDataSource.RemoteDataSourceCallback<List<Photo>> {
            override fun onSuccess(response: List<Photo>) {
               callback.onSuccess(response)
            }

            override fun onError(errorMessage: String) {
                callback.onError(errorMessage)
            }

            override fun isLoading(isLoading: Boolean) {
                callback.isLoading(isLoading)
            }

        })
    }
}