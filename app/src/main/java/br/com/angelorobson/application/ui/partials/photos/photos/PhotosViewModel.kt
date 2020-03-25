package br.com.angelorobson.application.ui.partials.photos.photos

import br.com.angelorobson.application.util.BaseViewModel
import br.com.angelorobson.application.util.EventLiveData
import br.com.angelorobson.domain.Photo
import br.com.angelorobson.service.utils.UseCaseBaseCallback
import br.com.angelorobson.usecases.remote.photos.ClearJobsUseCase
import br.com.angelorobson.usecases.remote.photos.GetPhotosUseCase

class PhotosViewModel(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val clearJobsUseCase: ClearJobsUseCase
) : BaseViewModel<List<Photo>>() {

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
                isLoadingEventObserver.value = EventLiveData(isLoading)
            }

            override fun onError(errorDescription: String) {
                errorObserver.value = EventLiveData(errorDescription)
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        clearJobsUseCase.clearJobs()
    }

}