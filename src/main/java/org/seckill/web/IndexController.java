package org.seckill.web;

import org.seckill.constant.WebConst;
import org.seckill.dto.Page;
import org.seckill.entity.Contents;
import org.seckill.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController extends BaseController{

    @Autowired
    private ArticleService articleService;

    @RequestMapping("testEl")
    public String testEl(Model model){
        return "theme/testel";
    }

    @RequestMapping(value = "page/{pageId}")
    public String index(HttpServletRequest request, @PathVariable int pageId,@RequestParam(value = "limit", defaultValue = "12") int limit){
        pageId = pageId < 0 || pageId > WebConst.MAX_PAGE ? 1 : pageId;
        List<Contents> articles = articleService.queryAll(limit,10*(pageId-1));
        //获取文章总数
        Integer total = articleService.getContentsCount();

        //构造page
        Page<Contents> page = new Page<Contents>(total, pageId, 10, articles);
        request.setAttribute("page", page);
        return "theme/themeindex";
    }

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.index(request, 1, limit);
    }
}
