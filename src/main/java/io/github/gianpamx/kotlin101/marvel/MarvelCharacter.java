package io.github.gianpamx.kotlin101.marvel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class MarvelCharacter {
    private final MarvelThumbnail thumbnail;

    MarvelCharacter() {
        this(null);
    }

    MarvelCharacter(MarvelThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public MarvelThumbnail getThumbnail() {
        return thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarvelCharacter that = (MarvelCharacter) o;

        return thumbnail != null ? thumbnail.equals(that.thumbnail) : that.thumbnail == null;
    }

    @Override
    public int hashCode() {
        return thumbnail != null ? thumbnail.hashCode() : 0;
    }
}
