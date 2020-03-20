package br.com.soluevo.www.application.ui

import android.app.Application
import br.com.soluevo.www.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@Application)
            modules(
                networkModule,
                apiModule,
                remoteDataSourceModule,
                useCaseModule,
                viewModuleModule
            )
        }
    }

}