package academy.mindswap.commitAir.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String iata;

    @OneToOne(mappedBy = "airport")
    private Country country;


    /*@OneToOne(mappedBy = "from")
    private Flight flight_from;

    @OneToOne(mappedBy = "to")
    private Flight flight_to;*/

}
