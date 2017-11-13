package org.seckill.entity;

public class Contents {
    // post表主键
    private Integer cid;
    // 内容标题
//    @NotEmpty(message = "标题不能为空")
//    @Length(max = MAX_TITLE_COUNT, message = "文章标题最多可以输入%d个字符")
    private String title;
    // 路径
    private String slug;
    // 内容生成时的GMT unix时间戳
    private Integer created;
    // 内容更改时的GMT unix时间戳
    private Integer modified;
    // 内容文字
//    @NotEmpty(message = "内容不能为空")
//    @Length(max = MAX_TEXT_COUNT, message = "文章内容最多可以输入%d个字符")
    private String content;
    // 内容所属用户id
    private Integer authorId;
    // 点击次数
    private Integer hits;
    // 内容类别
    private String type;
    // 内容类型，markdown或者html
    private String fmtType;
    // 文章缩略图
    private String thumbImg;
    // 标签列表
    private String tags;
    // 分类列表
    private String categories;
    // 内容状态
    private String status;
    // 内容所属评论数
    private Integer commentsNum;
    // 是否允许评论
    private Boolean allowComment;
    // 是否允许ping
    private Boolean allowPing;
    // 允许出现在聚合中
    private Boolean allowFeed;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFmtType() {
        return fmtType;
    }

    public void setFmtType(String fmtType) {
        this.fmtType = fmtType;
    }

    public String getThumbImg() {
        return thumbImg;
    }

    public void setThumbImg(String thumbImg) {
        this.thumbImg = thumbImg;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Boolean getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Boolean getAllowPing() {
        return allowPing;
    }

    public void setAllowPing(Boolean allowPing) {
        this.allowPing = allowPing;
    }

    public Boolean getAllowFeed() {
        return allowFeed;
    }

    public void setAllowFeed(Boolean allowFeed) {
        this.allowFeed = allowFeed;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "cid=" + cid +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", content='" + content + '\'' +
                ", authorId=" + authorId +
                ", hits=" + hits +
                ", type='" + type + '\'' +
                ", fmtType='" + fmtType + '\'' +
                ", thumbImg='" + thumbImg + '\'' +
                ", tags='" + tags + '\'' +
                ", categories='" + categories + '\'' +
                ", status='" + status + '\'' +
                ", commentsNum=" + commentsNum +
                ", allowComment=" + allowComment +
                ", allowPing=" + allowPing +
                ", allowFeed=" + allowFeed +
                '}';
    }
}
