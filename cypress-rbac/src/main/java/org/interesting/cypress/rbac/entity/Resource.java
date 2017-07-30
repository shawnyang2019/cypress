package org.interesting.cypress.rbac.entity;

/**
 * 资源
 * 
 * @author vv
 * @since 2017/7/30.
 */
public class Resource {

    private static final String SEPARATOR = "/";

    private Integer id;

    /**
     * 资源所在路径,分隔符如下：
     * 
     * @see Resource#SEPARATOR
     */
    private String path;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 此项资源是否有级联关系，若有，则拥有此资源的可读权限等价于拥有所有子项的可读权限
     */
    private boolean cascade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean cascade) {
        this.cascade = cascade;
    }
}
