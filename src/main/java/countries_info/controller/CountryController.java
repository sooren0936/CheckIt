package countries_info.controller;

import com.sun.istack.NotNull;
import countries_info.data.Country;
import countries_info.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public String main(@NotNull Map<String, Object> model) throws IOException {
        Iterable<Country> dataOfCountries = countryRepository.findAll();
        model.put("dataOfCountries", dataOfCountries);
        return "main";
    }

    @PostMapping("filterName")
    public String filterName(@NotNull @RequestParam String filterName, @NotNull Map<String, Object> model) {
        Iterable<Country> dataOfCountries;
        if (filterName != null && !filterName.isEmpty()) {
            dataOfCountries = countryRepository.findByName(filterName);
        } else {
            dataOfCountries = countryRepository.findAll();
        }
        model.put("dataOfCountries", dataOfCountries);
        return "main";
    }

    @PostMapping("filterTopLevelDomain")
    public String filterTopLevelDomain(@NotNull @RequestParam String filterTopLevelDomain, @NotNull Map<String, Object> model) {
        Iterable<Country> dataOfCountries;

        if (filterTopLevelDomain != null && !filterTopLevelDomain.isEmpty()) {
            dataOfCountries = countryRepository.findByTopLevelDomain(filterTopLevelDomain);
        } else {
            dataOfCountries = countryRepository.findAll();
        }
        model.put("dataOfCountries", dataOfCountries);
        return "main";
    }
}
