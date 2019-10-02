package io.github.gianpamx.kotlin101.unsplash

import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import io.github.gianpamx.kotlin101.GalleryDataSource
import com.github.kittinunf.result.Result


class UnsplashDataSource(private val authorization: String) : GalleryDataSource {
    override fun getImages(): List<String> {
        val (_, _, result) = "https://api.unsplash.com/photos"
                .httpGet()
                .header("Authorization", "Client-ID $authorization")
                .responseObject<List<UnspashPhoto>>()

        return when (result) {
            is Result.Success -> {
                return result.value.map { it.urls["small"] ?: "" }
            }
            else -> emptyList()
        }
    }
}
