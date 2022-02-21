package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wsb.homeless.service.PersonService;

@Controller
@AllArgsConstructor
public class DonorController {

    private final PersonService personService;

    @GetMapping("donor")
    public String deleteUser(Model model) {
        return "donor";
    }
}
