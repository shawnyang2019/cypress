package org.interesting.cypress.job.core;

/**
 * @author vv
 * @since 2017/8/11.
 */
public interface JobListener {

    /**
     * 进度发生变化时触发
     * @param status 进度状态
     */
    void statusChanged(int status);
}
