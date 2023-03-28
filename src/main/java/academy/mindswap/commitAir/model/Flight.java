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
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String flight_iata;
    @Column
    private String dep_iata;
    @Column
    private String arr_iata;
    @Column
    private String dep_time;
    @Column
    private String arr_time;
    @Column
    private int duration;
    @Column
    private String status;
    @Column
    private int AvailableSeats;

    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings;
}