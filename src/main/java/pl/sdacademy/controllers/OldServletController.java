package pl.sdacademy.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.dao.CustomerDao;
import pl.sdacademy.dto.DaysDto;
import pl.sdacademy.entity.Customer;
import pl.sdacademy.service.SessionCounterService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/zabezpieczone/old")
public class OldServletController {
    private static final Logger LOG = LoggerFactory.getLogger(OldServletController.class);

    @Autowired
    private SessionCounterService sessionCounterService;

    @RequestMapping("days")
    public ModelAndView getDaysList(
            @RequestParam(value = "days", required = false, defaultValue = "0") Integer days) {

        Map<String, Object> model = new HashMap<>();
        LocalDateTime dt = LocalDateTime.now();
        List<DaysDto> daysList = new LinkedList<>();
        for (int i = 1; i <= days; i++) {
            LocalDateTime after = dt.plusDays(i);
            DaysDto daysDto = new DaysDto();
            daysDto.setAfter(after);
            daysDto.setDaysAfter(i);
            daysList.add(daysDto);
        }
        model.put("dupa", daysList);

        model.put("daysParam", days);
        return new ModelAndView("days", model);
    }


    @RequestMapping("headers")
    public ModelAndView getHeadersList(
            @RequestHeader Map<String, String> headers,
            @CookieValue("dupneCiasteczko") String cookie,
            HttpServletResponse res
    ){
        Map<String, Object> model = new HashMap<>();
        model.put("dupa", headers);
        //sprawdzalismy bez powodu jak dodac ciasteczko
        res.addCookie(new Cookie("dupneCiasteczko", "test123"));
        return new ModelAndView("headers", model);
    }

    @RequestMapping("counter")
    public ModelAndView getCounts(HttpServletRequest req, HttpServletResponse resp){
        Map<String, Object> model = new HashMap<>();
        Integer cookieCounter = sessionCounterService.getAndUpdateCoockieCounter(req, resp);
        Integer sessionCounter = sessionCounterService.getAndUpdateSessionCounter(req.getSession());
        model.put("sessionCounter", sessionCounter);
        model.put("cookieCounter", cookieCounter);
        return new ModelAndView("counters", model);
    }
}
