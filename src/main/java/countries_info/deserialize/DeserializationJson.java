package countries_info.deserialize;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import countries_info.data.Country;

import java.io.IOException;
import java.net.URL;

public class DeserializationJson {
    public static Country[] deserialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final URL url = new URL("https://restcountries.eu/rest/v2/all");
        return objectMapper.readValue(url, Country[].class);
    }
}
