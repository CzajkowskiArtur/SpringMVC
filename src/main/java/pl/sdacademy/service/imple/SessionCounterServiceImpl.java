package pl.sdacademy.service.imple;

import org.springframework.stereotype.Service;
import pl.sdacademy.service.SessionCounterService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class SessionCounterServiceImpl implements SessionCounterService {
    @Override
    public int getAndUpdateCoockieCounter(HttpServletRequest req, HttpServletResponse resp) {
        Integer counter = 1;
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("CounterCookie")) {
                counter = Integer.valueOf(cookie.getValue());
                counter++;
                break;
            }
        }
        resp.addCookie(new Cookie("CounterCookie", counter.toString()));
        return counter;
    }

    @Override
    public int getAndUpdateSessionCounter(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 1;
            session.setAttribute("counter", counter);
            return counter;
        } else {
            counter++;
            session.setAttribute("counter", counter);
            return counter;
        }

    }
}
