package countries_info.repository;

import countries_info.data.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findByName(String name);

    @Query(value = "SELECT * FROM country_top_level_domain a inner join country b ON a.country_id = b.id " +
            "WHERE a.top_level_domain like %:topLevelDomain% ", nativeQuery = true)
    List<Country> findByTopLevelDomain(@Param("topLevelDomain") String topLevelDomain);
}
