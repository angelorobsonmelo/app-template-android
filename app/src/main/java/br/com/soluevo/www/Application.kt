package br.com.soluevo.www

import android.app.Application
import br.com.soluevo.www.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@Application)
            modules(
                networkModule
            )
        }
    }

}