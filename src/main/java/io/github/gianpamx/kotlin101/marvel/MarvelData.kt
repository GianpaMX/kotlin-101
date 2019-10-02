package io.github.gianpamx.kotlin101.marvel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MarvelData(
        val results: List<MarvelCharacter>? = null
)
