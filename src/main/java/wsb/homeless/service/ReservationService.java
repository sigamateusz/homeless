package wsb.homeless.service;

import wsb.homeless.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getAllReservations();

    void add(Reservation reservation);

    Optional<Reservation> findById(int id);

    void delete(Reservation reservation);
}
