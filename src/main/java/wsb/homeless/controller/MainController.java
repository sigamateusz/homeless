package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import wsb.homeless.model.Person;
import wsb.homeless.model.Reservation;
import wsb.homeless.service.ReservationService;

@Controller
@AllArgsConstructor
public class MainController {

    private final ReservationService reservationService;

    @GetMapping("/")
    public String viewMain(Model model) {
//        model.addAttribute("reservations", reservationService.getAllReservations());
//        model.addAttribute("newReservation", new Reservation(new Person()));
        return "main";
    }

//    @PostMapping("/add-reservation")
//    public String addRecord(@ModelAttribute Reservation reservation) {
//        reservationService.add(reservation);
//        return "redirect:/";
//    }

//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        var reservation = reservationService.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + id));
//        reservationService.delete(reservation);
//        return "redirect:/";
//    }
}
