package countries_info.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Languages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languagesId;
    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;

    public Languages() {
    }
}
