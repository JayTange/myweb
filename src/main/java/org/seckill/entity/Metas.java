package org.seckill.entity;

public class Metas {
    // 项目主键
    private Integer mid;
    // 名称
    private String  name;
    // 项目缩略名
    private String  slug;
    // 项目类型
    private String  type;
    // 选项描述
    private String  description;
    // 项目排序
    private Integer sort;
    // 父级
    private Integer parent;
    // 文章数
    private Integer count;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Metas{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", sort=" + sort +
                ", parent=" + parent +
                ", count=" + count +
                '}';
    }
}
