package io.github.gianpamx.kotlin101.marvel;

import io.github.gianpamx.kotlin101.GalleryDataSource;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarvelDataSource implements GalleryDataSource {
    private final String publicKey;
    private final String privateKey;

    public MarvelDataSource(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    @Override
    public List<String> getImages() throws Exception {
        final String ts = String.valueOf(System.currentTimeMillis());
        final String hash = md5(ts + privateKey + publicKey);

        final Map<String, String> authorizationDetails = getAuthorizationDetails(ts, hash);

        final RestTemplate restTemplate = new RestTemplate();

        try {
            final MarvelResponse marvelResponse = restTemplate.getForObject("https://gateway.marvel.com:443/v1/public/characters?apikey={apikey}&ts={ts}&hash={hash}", MarvelResponse.class, authorizationDetails);

            return map(marvelResponse);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private List<String> map(MarvelResponse marvelResponse) {
        final ArrayList<String> result = new ArrayList<>();
        for (final MarvelCharacter character : marvelResponse.getData().getResults()) {
            final String image = character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension();
            result.add(image);
        }
        return result;
    }

    private Map<String, String> getAuthorizationDetails(String ts, String hash) {
        final Map<String, String> details = new HashMap<>();
        details.put("apikey", publicKey);
        details.put("ts", ts);
        details.put("hash", hash);
        return details;
    }

    private String md5(String s) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] digested = md.digest(s.getBytes(StandardCharsets.UTF_8));
        final StringBuilder sb = new StringBuilder();
        for (byte b : digested) {
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString();
    }
}
