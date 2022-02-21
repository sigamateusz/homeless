package wsb.homeless.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.homeless.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
