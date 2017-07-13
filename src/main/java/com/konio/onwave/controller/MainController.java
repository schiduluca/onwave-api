package com.konio.onwave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lschidu on 7/13/17.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public ModelAndView returnWelcomeScreen() {
        return new ModelAndView("redirect:swagger-ui.html");
    }
}
