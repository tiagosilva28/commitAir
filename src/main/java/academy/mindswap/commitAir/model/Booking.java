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
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double finalPrice;

    @ManyToOne(targetEntity = User.class)
    private User user;
    
    @ManyToMany(targetEntity = Passenger.class)
    private List<Passenger> passengers;

    @ManyToOne
    private Flight flight;

    public Booking(User user, List<Passenger> passengers, Flight flight) {
        this.user = user;
        this.passengers = passengers;
        this.flight = flight;
    }
}
