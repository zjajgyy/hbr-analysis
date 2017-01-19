package com.bigdata.hbr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by percy on 2017/1/9.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    Map<String, String> pages = new HashMap<>();

    public HomeController() {
        this.pages.put("login", "login");
        this.pages.put("register", "register");
        this.pages.put("admin-patient", "admin-patient");
        this.pages.put("admin", "admin-doctor");
        this.pages.put("doctor", "doctor-patient");
        this.pages.put("user", "user-upload");
        this.pages.put("user-report", "user-report");
    }

    @RequestMapping("/")
    public ModelAndView direct(String location, HttpSession session) {

        if (location == null || location.equals("")) {
            location = "login";
        }

        if ((!location.equals("register") && !location.equals("login")) &&
                session.getAttribute("username") == null) {
            location = "login";
        }

        ModelAndView mv = new ModelAndView(pages.get(location));
        mv.addObject("username", session.getAttribute("username"));
        mv.addObject("name", session.getAttribute("name"));
        return mv;
    }

}
