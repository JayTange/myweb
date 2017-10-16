package org.seckill.web;

import org.seckill.dto.Page;
import org.seckill.entity.Contents;
import org.seckill.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContentsService contentsService;

    @RequestMapping(value = "/articlemanage/{pageId}",method = RequestMethod.GET)
    public String articleManage(@PathVariable("pageId")Integer pageId,Model model) {
        List<Contents> list = contentsService.getContentsList(10,(pageId+1)*10);
        //TODO 获取总数
        Page<Contents> page = new Page<Contents>(20,pageId+1,10,list);
        model.addAttribute("page",page);
        return "articlemanage";
    }

    @RequestMapping(value = "articlemanage",method = RequestMethod.GET)
    public String indexArcticle(Model model){
        return "redirect:/articlemanage/0";
    }
}
