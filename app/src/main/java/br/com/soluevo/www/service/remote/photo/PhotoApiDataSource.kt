package br.com.soluevo.www.service.remote.photo

import br.com.soluevo.www.domain.Photo
import io.reactivex.Observable
import retrofit2.http.GET

interface PhotoApiDataSource {

    @GET("albums/1/photos")
    fun getPhotos(): Observable<List<Photo>>
}