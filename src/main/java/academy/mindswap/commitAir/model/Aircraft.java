package academy.mindswap.commitAir.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="aircrafts")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelNumber;

    @Column(nullable = false)
    private int registrationNumber;

    @Column(nullable = false)
    private int capacity;

    /*@OneToMany(mappedBy = "aircraft")
    private List <Flight> flights;*/

    @OneToMany(mappedBy = "aircraft")
    private List <Seat> seats;

}
