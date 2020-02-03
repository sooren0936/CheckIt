package countries_info.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RegionalBlocs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionalBlocsId;
    private String acronym;
    private String name;

    @ElementCollection
    private List<String> otherAcronyms;

    @ElementCollection
    private List<String> otherNames;

    public RegionalBlocs() {
    }
}
