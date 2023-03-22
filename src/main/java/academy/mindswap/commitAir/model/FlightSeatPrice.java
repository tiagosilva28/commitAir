package academy.mindswap.commitAir.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="flight_seats")
public class FlightSeatPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private double price;

    @ManyToOne(targetEntity = Booking.class)
    private Booking booking;

    @OneToOne(targetEntity = Flight.class)
    private Flight flight;

    @OneToOne(targetEntity = Passenger.class)
    private Passenger passenger;

}
