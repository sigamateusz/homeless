package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wsb.homeless.model.Person;
import wsb.homeless.service.PersonService;

@Controller
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("person/info/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Person person = personService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + id));
        model.addAttribute("person", person);
        model.addAttribute("address", person.getAddress());
        return "info";
    }
}
