package countries_info.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String population;
    private String flag;

    @ElementCollection
    @Column(name = "topLevelDomain")
    private List<String> topLevelDomain;

    @ElementCollection
    private List<String> latlng;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "currencies_currenciesId")
    private List<Currencies> currencies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "languages_languagesId")
    private List<Languages> languages;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "translations_translationsId")
    private List<Translations> translations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "regionalBlocs_regionalBlocsId")
    private List<RegionalBlocs> regionalBlocs;

    public Country() {
    }
}




