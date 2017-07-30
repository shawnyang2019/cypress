package org.interesting.cypress.rbac.entity;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * Permission(resource:op:instance)
 * 
 * @author vv
 * @since 2017/7/30.
 */
public class Permission {

    /**
     * 资源
     */
    private Integer resourceId;

    /**
     * 操作
     */
    private Op operation;

    /**
     * 实例
     */
    private String instance;

    public Permission(Integer resourceId, Op operation) {
        this(resourceId, operation, null);
    }

    public Permission(Integer resourceId, Op operation, String instance) {
        this.resourceId = resourceId;
        this.operation = operation;
        this.instance = instance;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Op getOperation() {
        return operation;
    }

    public void setOperation(Op operation) {
        this.operation = operation;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(operation.getValue());
        sb.append(":").append(resourceId);
        if (StringUtils.isNoneBlank()) {
            sb.append(instance);
        }
        return sb.toString();
    }
}
