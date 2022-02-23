package wsb.homeless.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class NeedyPersonController {

    @GetMapping("needy-person")
    public String deleteUser(Model model) {
        return "needy-person";
    }
}
