package io.github.gianpamx.kotlin101;

import java.util.List;

public interface GalleryDataSource {
    List<String> getImages() throws Exception;
}
