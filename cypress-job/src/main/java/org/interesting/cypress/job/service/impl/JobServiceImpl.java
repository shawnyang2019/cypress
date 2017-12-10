package org.interesting.cypress.job.service.impl;

import org.interesting.cypress.job.demo.core.JobListener;
import org.interesting.cypress.job.demo.handler.JobHandler;
import org.interesting.cypress.job.service.JobService;

/**
 * @author vv
 * @since 2017/8/11.
 */
public class JobServiceImpl implements JobService {
    @Override
    public void start(String jobId) {

    }

    @Override
    public void stop(String jobId) {

    }

    @Override
    public String submit(JobHandler handler, JobListener listener) {
        return null;
    }

    @Override
    public void resume(String jobId) {

    }
}
