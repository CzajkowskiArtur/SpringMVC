package pl.sdacademy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.dao.impl.ProductDao;
import pl.sdacademy.entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnonymousUserController {

   @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public ModelAndView indexPage(@RequestParam(name="count", defaultValue = "16") Integer count){
        Map<String, Object> model = new HashMap<>();
        model.put("topProducts",productDao.getTopProducts(count));





        return  new ModelAndView("index", model);
    }
}
