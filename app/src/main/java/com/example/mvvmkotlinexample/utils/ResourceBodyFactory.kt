package com.example.mvvmkotlinexample.utils

import co.infinum.retromock.BodyFactory
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets

class ResourceBodyFactory: BodyFactory {
    @Throws(IOException::class)
    override fun create(input: String): InputStream {
        return FileUtils
            .readResourceFile(input)
            .byteInputStream(StandardCharsets.UTF_8)
    }
}