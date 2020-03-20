package br.com.soluevo.www.service.remote.photo

import android.util.Log
import br.com.soluevo.www.domain.Photo
import br.com.soluevo.www.service.utils.RemoteDataSourceClearJobs
import br.com.stant.obras.service.BaseRemoteDataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class PhotoRemoteDataSourceImpl(private val apiDataSource: PhotoApiDataSource) :
    PhotoRemoteDataSource, CoroutineScope {

    override val coroutineContext = Main

    private val jobs = ArrayList<Job>()

    private infix fun ArrayList<Job>.add(job: Job) {
        this.add(job)
    }

    override fun getPhotos(callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Photo>>) {
        jobs add launch {
            callback.isLoading(true)
            try {
                val photos = apiDataSource.getPhotos().await()
                callback.onSuccess(photos)
                Log.d("photos list", photos.toString())
            } catch (t: Throwable) {
                callback.onError(t.localizedMessage)
            } finally {
                callback.isLoading(false)
            }
        }
    }

    override fun clearJobs() {
        jobs.forEach { if (!it.isCancelled) it.cancel() }
    }

}