package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wsb.homeless.model.Person;
import wsb.homeless.service.PersonService;

@Controller
@AllArgsConstructor
public class NeedyPersonController {

    private final PersonService personService;

    @GetMapping("needy-person")
    public String deleteUser(Model model) {
        return "needy-person";
    }
}
