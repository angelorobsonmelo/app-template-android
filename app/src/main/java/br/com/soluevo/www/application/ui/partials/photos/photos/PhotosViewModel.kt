package br.com.soluevo.www.application.ui.partials.photos.photos

import androidx.lifecycle.MutableLiveData
import br.com.soluevo.www.application.util.BaseViewModel
import br.com.soluevo.www.application.util.EventLiveData
import br.com.soluevo.www.domain.Photo
import br.com.soluevo.www.service.utils.UseCaseBaseCallback
import br.com.soluevo.www.usecases.remote.photos.GetPhotosUseCase

class PhotosViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : BaseViewModel<List<Photo>>() {

    val savePhotosObserver = MutableLiveData<EventLiveData<Boolean>>()
    val removeAllPhotosObserver = MutableLiveData<EventLiveData<Boolean>>()

    fun getPosts() {
        getPhotosUseCase.getPosts(object :
            UseCaseBaseCallback.UseCaseCallback<List<Photo>> {

            override fun onSuccess(response: List<Photo>) {
                successObserver.value = EventLiveData(response)
            }

            override fun onEmptyData() {
                emptyObserver.value = EventLiveData(true)
            }

            override fun isLoading(isLoading: Boolean) {
                isLoadingEventObserver.value = EventLiveData(true)
            }

            override fun onError(errorDescription: String) {
                errorObserver.value = EventLiveData(errorDescription)
            }
        })
    }

}