package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wsb.homeless.model.DonorPlaceDTO;
import wsb.homeless.model.PlaceType;
import wsb.homeless.service.DonorPlaceServiceImpl;

import java.util.List;

@Controller
@AllArgsConstructor
public class DonorController {

    private final DonorPlaceServiceImpl donorPlaceService;

    @GetMapping("donor")
    public String donor(Model model) {
        model.addAttribute("newDonorPlace", new DonorPlaceDTO());
        model.addAttribute("placeTypes", PlaceType.values());
        return "donor";
    }

    @PostMapping(value = "/add-place")
    public String addRecord(@ModelAttribute DonorPlaceDTO donorPlaceDTO) {
        donorPlaceService.add(donorPlaceDTO);
        return "redirect:/";
    }

    @GetMapping(value = "/all", produces = "application/json")
    public @ResponseBody
    List<DonorPlaceDTO> getAll() {
        return donorPlaceService.getAll();
    }
}
