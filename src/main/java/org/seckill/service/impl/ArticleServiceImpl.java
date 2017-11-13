package org.seckill.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.seckill.constant.WebConst;
import org.seckill.dao.MetasDao;
import org.seckill.entity.Contents;
import org.seckill.entity.Metas;
import org.seckill.exception.TipException;
import org.seckill.service.ArticleService;
import org.seckill.service.ContentsService;
import org.seckill.util.CommonTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章服务实现类
 *
 * @author tnagj
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private MetasDao metasDao;

    @Autowired
    private ContentsService contentsService;

    /**
     * 发布文章
     *
     * @param contents
     */
    @Override
    public void publish(Contents contents) {
        if (null == contents) {
            throw new TipException("文章对象为空");
        }
        if (StringUtils.isBlank(contents.getTitle())) {
            throw new TipException("文章标题不能为空");
        }
        if (StringUtils.isBlank(contents.getContent())) {
            throw new TipException("文章内容不能为空");
        }
        int titleLength = contents.getTitle().length();
        if (titleLength > WebConst.MAX_TITLE_COUNT) {
            throw new TipException("文章标题过长");
        }
        int contentLength = contents.getContent().length();
        if (contentLength > WebConst.MAX_TEXT_COUNT) {
            throw new TipException("文章内容过长");
        }
//        if (null == contents.getAuthorId()) {
//            throw new TipException("请登录后发布文章");
//        }
        if (StringUtils.isNotBlank(contents.getSlug())) {
            if (contents.getSlug().length() < 5) {
                throw new TipException("路径太短了");
            }
            if (!CommonTUtils.isPath(contents.getSlug()))throw  new TipException("输入路径不合法");
            int slugCount = contentsService.getSlugCount();
            if (slugCount>0){
                throw new TipException("该路径已经存在，请重新输入");
            }
        }else {
            contents.setSlug(null);
        }
//        contents.setContent();
    }

    /**
     * 返回文章的标签
     *
     * @param type
     * @return
     */

    @Override
    public List<Metas> getArticleType(String type) {
        return metasDao.queryAll(type);
    }
}
