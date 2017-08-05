package org.interesting.cypress.rbac.entity;

/**
 * 资源操作描述
 * 
 * @author vv
 * @since 2017/7/30.
 */
public interface Op {

    String INSERT = "insert";

    String UPDATE = "update";

    String DELETE = "delete";

    String QUERY = "query";
}
