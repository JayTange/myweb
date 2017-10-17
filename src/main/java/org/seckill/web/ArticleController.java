package org.seckill.web;

import org.seckill.dto.Page;
import org.seckill.dto.WebResult;
import org.seckill.entity.Contents;
import org.seckill.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContentsService contentsService;

    /**
     * 显示文章列表
     * @param pageId
     * @param model
     * @return
     */
    @RequestMapping(value = "/articlemanage/{pageId}", method = RequestMethod.GET)
    public String articleManage(@PathVariable("pageId") Integer pageId, Model model) {
        //获取文章信息
        List<Contents> list = contentsService.getContentsList(10, (pageId - 1) * 10);
        // 获取文章总数
        Integer total = contentsService.getContentsCount();
        // 根据total和当前page，计算出页数
        Page<Contents> page = new Page<Contents>(total, pageId, 10, list);
        model.addAttribute("page", page);
        return "articlemanage";
    }

    @RequestMapping(value = "articlemanage", method = RequestMethod.GET)
    public String indexArcticle(Model model) {
        return "redirect:/articlemanage/1";
    }

    @RequestMapping(value = "/article/delete",method = RequestMethod.POST)
    @ResponseBody
    public WebResult deleteContent(@RequestBody Map<String,String> map){
        try{
            System.out.println("delete接受参数");
            System.out.println(map.get("cid"));
            return new WebResult(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new WebResult(false,"删除文章失败");
        }

    }
}
