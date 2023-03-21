package academy.mindswap.commitAir.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Airport from;
    @Column(nullable = false)
    private Airport to;
    @Column(nullable = false)
    private Date departureDate;
    @Column(nullable = false)
    private LocalTime departureTime;

    @Column(nullable = false)
    private Date arrivalDate;
    @Column(nullable = false)
    private LocalTime arrivalTime;


}
