package se.lexicon.lecturejpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

//@Entity(name = "TBL_STUDENTS")
@Entity
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // For id number generations
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Setter
    @Column(nullable = false, length = 100)
    private String firstName;

    @Setter
    @Column(nullable = false, length = 100)
    private String lastName;

    @Setter
    @Column(nullable = false, unique = true)
    private String email;

//    @Column(name = "_STATUS") // Custom Name in Table
    private boolean status;
    private LocalDateTime createDate;

    @Setter
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createDate = LocalDateTime.now();
    }

}