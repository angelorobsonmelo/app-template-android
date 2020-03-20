package br.com.soluevo.www.application.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.soluevo.www.R
import br.com.soluevo.www.application.ui.partials.photos.photos.PhotosViewModel
import br.com.soluevo.www.application.util.EventObserver
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: PhotosViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPosts()

        viewModel.successObserver.observe(this, EventObserver {
            print(it)
        })
    }
}
