package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wsb.homeless.service.DonorPlaceServiceImpl;

@Controller
@AllArgsConstructor
public class NeedyPersonController {

    private final DonorPlaceServiceImpl donorPlaceService;

    @GetMapping("needy-person")
    public String deleteUser(Model model) {
//        model.addAttribute("places", donorPlaceService.getAll());
        return "needy-person";
    }
}
