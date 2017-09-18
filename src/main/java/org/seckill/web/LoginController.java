package org.seckill.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

@Controller
@RequestMapping
public class LoginController {
    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public ModelAndView login(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "你好");
        mv.setViewName("first");
        return mv;
    }
}
