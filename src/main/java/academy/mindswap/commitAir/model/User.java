package academy.mindswap.commitAir.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String nationality;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
