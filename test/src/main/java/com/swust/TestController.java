package com.swust;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/practice")
    public ModelAndView toInteraction(ModelAndView view) {
        view = new ModelAndView("/hello");
        return view;
    }

    @GetMapping("/string")
    @ResponseBody
    public String toT(ModelAndView view) {
        return  "hello";
    }
}
