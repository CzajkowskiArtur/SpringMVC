package pl.sdacademy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.dao.CustomerDao;
import pl.sdacademy.dto.CustomerDto;
import pl.sdacademy.entity.Customer;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {


    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, HttpSession session) {
        Map<String, Object> model = new HashMap<>();

        Customer customer = customerDao.findCustomerByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            session.setAttribute("user", new CustomerDto(customer));
            String previousUrl = (String) session.getAttribute("requestedURL");
            if (previousUrl == null) {
                previousUrl = "zabezpieczone/";
            }
            session.removeAttribute("requestedURL");
            return new ModelAndView("redirect" + previousUrl);

        }

        model.put("error", "INCORRECT_CREDENTIALS");
        return new ModelAndView("login", model);
    }
}
