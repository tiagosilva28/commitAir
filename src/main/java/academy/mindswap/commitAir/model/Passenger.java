package academy.mindswap.commitAir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String nationality;

    /*@ManyToMany(mappedBy = "booking")
    private List<Booking> bookingList;*/

    @ManyToMany(mappedBy = "passengers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // for many to many
    private List<Booking> bookingList;

    @OneToOne(mappedBy = "passenger")
    private FlightSeatPrice flightSeatPrice;

}
