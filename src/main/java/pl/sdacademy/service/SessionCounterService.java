package pl.sdacademy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface SessionCounterService {
    public int getAndUpdateCoockieCounter(HttpServletRequest req, HttpServletResponse resp);
    public int getAndUpdateSessionCounter(HttpSession session);
}

