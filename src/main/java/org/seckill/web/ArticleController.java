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

/**
 * 文章管理
 */
@Controller
@RequestMapping(value = "/articlemanage")
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContentsService contentsService;

    /**
     * 显示文章列表
     *
     * @param pageId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{pageId}", method = RequestMethod.GET)
    public String articleManage(@PathVariable("pageId") Integer pageId, Model model) {
        //获取文章信息
        List<Contents> list = contentsService.getContentsList(10, (pageId - 1) * 10);
        // 获取文章总数
        Integer total = contentsService.getContentsCount();
        // 根据total和当前page，计算出页数
        Page<Contents> page = new Page<Contents>(total, pageId, 10, list);
        model.addAttribute("page", page);
        return "admin/articlemanage";
    }

    /**
     * 初次加载默认页数为1
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexArcticle(Model model) {
        return "redirect:/articlemanage/1";
    }

    /**
     * 删除文章
     *
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete/{cid}", method = RequestMethod.POST)
    @ResponseBody
    public WebResult deleteContent(@PathVariable("cid") Integer cid, Model model) {
        try {
            contentsService.deleteContent(cid);
            logger.info("删除文章+cidw为：" + cid);
            return new WebResult(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new WebResult(false, "删除文章失败");
        }
    }
}
