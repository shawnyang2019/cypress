package org.interesting.cypress.job.service;

import org.interesting.cypress.job.demo.core.JobListener;
import org.interesting.cypress.job.demo.handler.JobHandler;

/**
 * @author vv
 * @since 2017/8/11.
 */
public interface JobService {

    void start(String jobId);

    void stop(String jobId);

    /**
     *
     * @param handler
     * @param listener
     * @return jobId
     */
    String submit(JobHandler handler, JobListener listener);

    void resume(String jobId);

}
