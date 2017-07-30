package org.interesting.cypress.rbac.entity;

/**
 * @author vv
 * @since 2017/7/30.
 */
public enum Op {

    READ(1),  EXECUTE(2), MODIFY(3),DELETE(4), ALL(5);

    private Integer value;

    Op(Integer operation) {
        this.value = operation;
    }

    public Integer getValue() {
        return value;
    }
}
