package org.seckill.web;

import org.seckill.constant.WebConst;
import org.seckill.dto.Page;
import org.seckill.entity.Contents;
import org.seckill.exception.TipException;
import org.seckill.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @RequestMapping(value = "article/{cid}")
    public String getArticle(HttpServletRequest request,@PathVariable String cid){
        Contents contents = articleService.getContentByCid(cid);
        //如果文章不存在 直接跳转404页面
//        if (null == contents || "draft".equals(contents.getStatus())){
//            return this.
//        }
        request.setAttribute("article",contents);
        request.setAttribute("is_post",true);
        // 根据文章找出其评论
//        completeArticle(request, contents);
        updateArticleHit(contents.getCid(),contents.getHits());
        return "theme/post";

    }

    @Transactional(rollbackFor = TipException.class)
    protected void updateArticleHit(Integer cid,Integer contentHits){
        Integer hits = cache.hget("article", "hits");
        if (contentHits==null){
            contentHits = 0;
        }
        hits = (null==hits?1:hits+1);
        if (hits>=WebConst.HIT_EXCEED){
            Contents temp = new Contents();
            temp.setCid(cid);
            temp.setHits(contentHits+hits);
            articleService.updateByPrimaryKey(temp);
            cache.hset("article", "hits", 1);
        }else {
            cache.hset("article", "hits", hits);
        }
    }


}
