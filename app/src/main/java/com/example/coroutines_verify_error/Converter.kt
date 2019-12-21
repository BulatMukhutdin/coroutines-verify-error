package com.example.coroutines_verify_error

class Converter(private val foo: Foo) {

    suspend fun convert(): Profile =
        Profile(
            isOnline = true,
            lastOnlinePrettified = foo.foo()
        )
}