package countries_info;

import countries_info.data.Country;
import countries_info.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static countries_info.deserialize.DeserializationJson.deserialize;

@SpringBootApplication
public class ServingWebContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CountryService countryService) {
        return args -> {
            for (Country data : deserialize()) {
                countryService.save(data);
            }
        };
    }
}