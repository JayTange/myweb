package org.seckill.service.impl;

import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import org.seckill.constant.WebConst;
import org.seckill.dao.ContentsDao;
import org.seckill.dao.MetasDao;
import org.seckill.entity.Contents;
import org.seckill.entity.Metas;
import org.seckill.exception.TipException;
import org.seckill.service.ArticleService;
import org.seckill.service.ContentsService;
import org.seckill.util.CommonTUtils;
import org.seckill.util.DateKit;
import org.seckill.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章服务实现类
 *
 * @author tnagj
 */
@Service
@SuppressWarnings("SpringJavaAutowiringInspection")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private MetasDao metasDao;

    @Autowired
    private ContentsDao contentsDao;

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
//            if(!CommonTUtils.isPath(contents.getSlug())){
//                throw  new TipException("输入路径不合法");
//            }
            int slugCount = contentsDao.getSlugCount(contents.getSlug());
            if (slugCount>0){
                throw new TipException("该路径已经存在，请重新输入");
            }
        }else {
            contents.setSlug(null);
        }
        contents.setContent(EmojiParser.parseToAliases(contents.getContent()));
        int time = DateKit.getCurrentUnixTime();
        //创建时间
        contents.setCreated(time);
        //修改时间
        contents.setModified(time);
        //点击数
        contents.setHits(0);
        //评论数
        contents.setCommentsNum(0);

        String tags = contents.getTags();
        String categoris = contents.getCategories();

        contentsDao.insertContent(contents);
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

    @Override
    public Contents getContentByCid(String cid) {
        if (StringUtils.isNotBlank(cid)){
            if (Tools.isNumber(cid)){
                Contents contents = contentsDao.selectByPrimaryKey(Integer.valueOf(cid));
                if (contents!=null){
                    contents.setHits(contents.getHits()+1);
                    contentsDao.updateByPrimaryKey(contents);
                }
                return contents;
            }
        }
        return null;
    }

    @Override
    public void updateArticle(Contents contents) {
        if (null == contents || null == contents.getCid()){
            throw  new TipException("文章对象不能为空");
        }
        if (StringUtils.isBlank(contents.getTitle())){
            throw new TipException("标题不能为空");
        }
        if (StringUtils.isBlank(contents.getContent())){
            throw new TipException("内容不能为空");
        }
        if (contents.getTitle().length() > 200) {
            throw new TipException("文章标题过长");
        }
        if (contents.getContent().length() > 65000) {
            throw new TipException("文章内容过长");
        }
//        if (null == contents.getAuthorId()) {
//            throw new TipException("请登录后发布文章");
//        }
        if (StringUtils.isBlank(contents.getSlug())) {
            contents.setSlug(null);
        }
        int modifyTime = DateKit.getCurrentUnixTime();
        contents.setModified(modifyTime);

        contents.setContent(EmojiParser.parseToAliases(contents.getContent()));
        contentsDao.updateByPrimaryKeyWithCondition(contents);
    }

    @Override
    public List<Contents> queryAll(int limit, int offset) {
        List<Contents> contentsList = contentsDao.queryAll(limit,offset);
        return  contentsList;
    }

    @Override
    public Integer getContentsCount() {
        return contentsDao.getCount();
    }

}
