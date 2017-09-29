package org.seckill.web;

import org.seckill.dao.User;
import org.seckill.dto.SeckillResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public SeckillResult<Integer> login(User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        String password = user.getPassword();
        String compare = "123";
        if (password.equals(compare)){
            return new SeckillResult<Integer>(true,1);
        }else {
            return new SeckillResult<Integer>(false, "用户名或密码错误");
        }
    }


    @CrossOrigin
    @RequestMapping(value = "/crosslogin",method = RequestMethod.POST)
    public SeckillResult<Integer> crossLogin(@RequestParam(value = "userName")String userName,
                                                @RequestParam(value = "password")String password){
        System.out.println(userName);
        System.out.println(password);
        return new SeckillResult<Integer>(true,1);
    }

}
