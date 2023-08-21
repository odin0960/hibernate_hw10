package SpaceTravel.planets;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    private String id;

    @Column(name = "name", length = 500)
    private String name;
}
