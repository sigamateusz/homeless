package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wsb.homeless.model.DonorPlace;
import wsb.homeless.model.PlaceType;
import wsb.homeless.service.DonorPlaceService;

@Controller
@AllArgsConstructor
public class DonorController {

    private final DonorPlaceService donorPlaceService;

    @GetMapping("donor")
    public String donor(Model model) {
        model.addAttribute("newDonorPlace", new DonorPlace());
        model.addAttribute("placeTypes", PlaceType.values());
        return "donor";
    }

    @PostMapping("/add-place")
    public String addRecord(@ModelAttribute DonorPlace donorPlace) {
        donorPlaceService.add(donorPlace);
        return "redirect:/";
    }
}
