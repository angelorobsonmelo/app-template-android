package br.com.soluevo.www.service.remote.photo

import android.util.Log
import br.com.soluevo.www.domain.Photo
import br.com.stant.obras.service.BaseRemoteDataSource

class PhotoRemoteDataSourceImpl(private val apiDataSource: PhotoApiDataSource) :
    PhotoRemoteDataSource {

    override fun getPhotos(callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Photo>>) {
        callback.onSuccess(mutableListOf(Photo(1, "", "", "")))
        Log.d("get photos api", "tudo certo meu irmão!")
    }
}