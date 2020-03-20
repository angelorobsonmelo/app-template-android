package br.com.soluevo.www

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private val retrofit: Retrofit by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
