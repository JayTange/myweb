package org.seckill.web;

import org.seckill.dao.User;
import org.seckill.dto.SeckillResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user){
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        return "/list";
    }
}
