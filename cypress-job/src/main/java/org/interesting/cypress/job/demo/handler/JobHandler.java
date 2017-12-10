package org.interesting.cypress.job.demo.handler;

/**
 * @author vv
 * @since 2017/8/11.
 */
public interface JobHandler {
    void execute(String... params) throws Exception;
}
