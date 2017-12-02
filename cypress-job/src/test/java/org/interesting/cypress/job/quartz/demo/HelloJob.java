package org.interesting.cypress.job.quartz.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author vv
 * @since 2017/8/13.
 */
public class HelloJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloJob.class);

    public HelloJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info(">>>   Hello World! - " + new Date());
    }

}
