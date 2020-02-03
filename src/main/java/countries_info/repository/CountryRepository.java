package countries_info.repository;

import countries_info.data.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findByName(String name);

    @Query(value = "SELECT * FROM country_top_level_domain ctld INNER JOIN country c ON ctld.country_id = c.id " +
            "WHERE ctld.top_level_domain LIKE %:topLevelDomain% ", nativeQuery = true)
    List<Country> findByTopLevelDomain(@Param("topLevelDomain") String topLevelDomain);
}
