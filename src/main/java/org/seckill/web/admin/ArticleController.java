package org.seckill.web.admin;

import org.apache.commons.lang3.StringUtils;
import org.seckill.dao.ContentsDao;
import org.seckill.dto.Page;
import org.seckill.dto.RestResponseBo;
import org.seckill.dto.WebResult;
import org.seckill.entity.Contents;
import org.seckill.entity.Metas;
import org.seckill.entity.UserInfo;
import org.seckill.enums.Types;
import org.seckill.exception.TipException;
import org.seckill.service.ArticleService;
import org.seckill.service.ContentsService;
import org.seckill.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文章管理
 */
@Controller
@RequestMapping(value = "/articlemanage")
public class ArticleController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContentsService contentsService;

    @Autowired
    private ArticleService articleService;

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

    @RequestMapping(value = "/newarticle", method = RequestMethod.GET)
    public String newArticle(Model model) {
        List<Metas> categories = articleService.getArticleType("category");
        model.addAttribute("categories", categories);
        return "admin/articleedit";
    }

    @RequestMapping(value = "/publish")
    @ResponseBody
    public RestResponseBo publishArticle(Contents contents, HttpServletRequest request) {
        // 获取用户信息
        UserInfo user = this.user(request);
        // 获取uid
        if (user!= null) {
            contents.setAuthorId(user.getUid());
        } else {
            // user默认为1
            contents.setAuthorId(1);
        }
        contents.setType(Types.ARTICLE.getType());
        if (StringUtils.isBlank(contents.getCategories())) {
            contents.setCategories("默认分类");
        }
        try {
            articleService.publish(contents);

        } catch (Exception e) {
            String msg = "文章发布失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                logger.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }


    @RequestMapping(value = "/modify/{cid}")
    public String modifyPage(@PathVariable String cid,Model model){
        Contents contents = articleService.getContentByCid(cid);
        model.addAttribute("contents",contents);
        List<Metas> categories = articleService.getArticleType("category");
        model.addAttribute("categories", categories);
        return "admin/articleedit";
    }

    @RequestMapping(value = "/modify")
    @ResponseBody
    public RestResponseBo modifyArticle(Contents contents,HttpServletRequest request){
        UserInfo userInfo = this.user(request);
        if (userInfo!=null){
            contents.setAuthorId(userInfo.getUid());
        }else {
            contents.setAuthorId(1);
        }
        contents.setType(Types.ARTICLE.getType());
        try{
            articleService.updateArticle(contents);
            return RestResponseBo.ok();
        }catch (Exception e){
            String msg = "文章修改失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                logger.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
    }
}
