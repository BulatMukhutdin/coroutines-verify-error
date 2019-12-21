package com.example.coroutines_verify_error

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)

            modules(
                module {
                    factory {
                        Converter(get())
                    }

                    factory {
                        Foo()
                    }
                }
            )
        }
    }
}