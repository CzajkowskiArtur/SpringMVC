package pl.sdacademy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.dao.ProductDao;
import pl.sdacademy.dto.BasketProductDto;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AnonymousUserController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public ModelAndView indexPage(
            @RequestParam(name="count", defaultValue = "16") Integer count){
        Map<String, Object> model = new HashMap<>();
        model.put("topProducts", productDao.getTopProducts(count));
        return new ModelAndView("index", model);
    }

    @RequestMapping("/addToBasket")
    public ModelAndView addToBasket(
            @RequestParam(name="count", defaultValue = "16") Integer count,
            @RequestParam(name="productId", required = true) Integer productId,
            HttpSession session){
        Map<Integer, BasketProductDto> basketProductList = (Map<Integer, BasketProductDto>) session
                .getAttribute("basket");
        if(basketProductList == null){
            basketProductList = new HashMap<>();
        }

        //sprawdzamy czy w koszyku już jest taki produkt
        BasketProductDto product = basketProductList.get(productId);
        if(product == null){
            //produktu jeszcze nie ma w koszyku, dodajemy nowy z ilością 1
            product = new BasketProductDto();
            product.setProductId(productId);
            product.setCount(1);
            basketProductList.put(productId, product);
        }
        else{
            //produkt już był w koszyku, dodajemy liczebność o jeden
            product.setCount(product.getCount() + 1);
        }
        session.setAttribute("basket", basketProductList);
        return new ModelAndView("redirect:/?count="+count);
    }


}

