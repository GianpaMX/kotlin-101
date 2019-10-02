package io.github.gianpamx.kotlin101.marvel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class MarvelThumbnail {
    private final String path;

    private final String extension;

    MarvelThumbnail() {
        this(null, null);
    }

    MarvelThumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarvelThumbnail that = (MarvelThumbnail) o;

        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        return extension != null ? extension.equals(that.extension) : that.extension == null;
    }

    @Override
    public int hashCode() {
        int result = path != null ? path.hashCode() : 0;
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }
}
