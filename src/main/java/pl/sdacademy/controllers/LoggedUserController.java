package pl.sdacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/zabezpieczone")
public class LoggedUserController {

    @RequestMapping("/")
    public ModelAndView orders(){
        Map<String,Object> model = new HashMap<>();
        //TODO
        //NAlezy pobrac ze stworzonego DAO wszystkie zamówienia dla użytkownika którego dane są w sesji pod kluczem"user"patrz LoggedUserFilter)


        return new ModelAndView("orders/",model);
    }
}
