package br.com.soluevo.www.application.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.soluevo.www.R
import br.com.soluevo.www.application.util.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationHostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.host_navigation_activity)

    }
}
