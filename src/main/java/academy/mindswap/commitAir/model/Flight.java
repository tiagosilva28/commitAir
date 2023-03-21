package academy.mindswap.commitAir.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.generic.TABLESWITCH;

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
    private Date departureDate;
    @Column(nullable = false)
    private LocalTime departureTime;

    @Column(nullable = false)
    private Date arrivalDate;
    @Column(nullable = false)
    private LocalTime arrivalTime;

    @OneToOne(mappedBy = "flight")
    private FlightSeatPrice flightSeatPrice;

    @ManyToOne(targetEntity = Aircraft.class)
    private Aircraft aircraft;

    //@OneToOne(mappedBy = "flight_from")
    @OneToOne(targetEntity = Airport.class)
    private Airport from;

    //@OneToOne(mappedBy = "flight_to")
    @OneToOne(targetEntity = Airport.class)
    private Airport to;
}
