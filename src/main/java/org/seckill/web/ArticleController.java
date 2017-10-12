package org.seckill.web;

import org.seckill.entity.Contents;
import org.seckill.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContentsService contentsService;

    @RequestMapping(value = "/articlemanage",method = RequestMethod.GET)
    public String articleManage(Model model) {
        List<Contents> list = contentsService.getContentsList();
        model.addAttribute("list",list);
        return "articlemanage";
    }
}
