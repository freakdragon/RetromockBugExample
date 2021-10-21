package com.example.mvvmkotlinexample.utils

object FileUtils {
    fun readResourceFile(fileName: String): String {
        return javaClass.classLoader
            ?.getResourceAsStream(fileName)
            ?.bufferedReader()
            ?.readText()
            ?: ""
    }
}