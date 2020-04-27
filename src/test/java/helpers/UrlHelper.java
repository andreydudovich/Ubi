package helpers;

import org.springframework.web.util.UriComponentsBuilder;

import static configuration.PropertiesConfiguration.getEndpoint;

public class UrlHelper {

    public static UriComponentsBuilder buildDeckUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(getEndpoint());
    }
}
