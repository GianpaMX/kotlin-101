package io.github.gianpamx.kotlin101.marvel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class MarvelData {
    private final List<MarvelCharacter> results;

    MarvelData() {
        this(null);
    }

    MarvelData(List<MarvelCharacter> results) {
        this.results = results;
    }

    public List<MarvelCharacter> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarvelData that = (MarvelData) o;

        return results != null ? results.equals(that.results) : that.results == null;
    }

    @Override
    public int hashCode() {
        return results != null ? results.hashCode() : 0;
    }
}
