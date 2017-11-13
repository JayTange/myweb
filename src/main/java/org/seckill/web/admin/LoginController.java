package org.seckill.web.admin;

import org.seckill.dao.User;
import org.seckill.dto.WebResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Integer> login(User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        String password = user.getPassword();
        String passwordCompare = "123456";
        String userNameCompare = "admin";
        String username = user.getUserName();

        if (password.equals(passwordCompare)&&username.equals(userNameCompare)){
            return new WebResult<Integer>(true,1);
        }else {
            logger.info("登录失败");
            return new WebResult<Integer>(false, "用户名或密码错误");
        }
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }

}
