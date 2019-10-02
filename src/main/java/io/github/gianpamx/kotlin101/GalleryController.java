package io.github.gianpamx.kotlin101;

import io.github.gianpamx.kotlin101.marvel.MarvelDataSource;
import io.github.gianpamx.kotlin101.unsplash.UnsplashDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GalleryController {

    // private final GalleryDataSource dataSource = new MarvelDataSource(System.getenv("marvelPublicKey"), System.getenv("marvelPrivateKey"));
    private final GalleryDataSource dataSource = new UnsplashDataSource(System.getenv("unsplashAccessKey"));

    @RequestMapping("/gallery")
    public String gallery(Model model) throws Exception {
        final List<String> images = dataSource.getImages();

        model.addAttribute("images", images);

        return "gallery";
    }
}
