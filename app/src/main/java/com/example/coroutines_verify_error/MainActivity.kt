package com.example.coroutines_verify_error

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.IO) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            val foo = Foo()
            val converter = Converter(foo)

            converter.convert()
        }
    }

    override fun onDestroy() {
        cancel()

        super.onDestroy()
    }
}
