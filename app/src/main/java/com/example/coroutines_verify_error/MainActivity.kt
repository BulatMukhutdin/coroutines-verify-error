package com.example.coroutines_verify_error

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.IO) {

    private val converter: Converter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            converter.convert()
        }
    }

    override fun onDestroy() {
        cancel()

        super.onDestroy()
    }
}
