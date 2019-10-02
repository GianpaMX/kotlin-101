package io.github.gianpamx.kotlin101.marvel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class MarvelResponse {
    private final MarvelData data;

    MarvelResponse() {
        this(null);
    }

    MarvelResponse(MarvelData data) {
        this.data = data;
    }

    public MarvelData getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarvelResponse that = (MarvelResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
