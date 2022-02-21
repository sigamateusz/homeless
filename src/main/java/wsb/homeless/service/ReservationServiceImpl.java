package wsb.homeless.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.homeless.model.Reservation;
import wsb.homeless.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final PersonService personService;
    private final AddressService addressService;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void add(Reservation reservation) {
        var person = reservation.getPerson();
        person.setAddress(addressService.add(person.getAddress()));
        reservation.setPerson(personService.add(person));
        reservationRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> findById(int id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
