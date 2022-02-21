package wsb.homeless.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Person person;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate bookingDate;

    public Reservation(Person person) {
        this.person = person;
    }
}
