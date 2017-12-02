package org.interesting.cypress.job.core;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * 此处触发具体的任务。
 * 
 * @see DynamicScheduler 通过此调度器动态生成jobBean,时机OK，调度器会触发
 *      {@link #executeInternal(JobExecutionContext)}
 * @author vv
 * @since 2017/8/11.
 */
public class CypressJobBean extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // load jobId
        JobKey jobKey = context.getTrigger().getJobKey();
        Integer jobId = Integer.valueOf(jobKey.getName());

        // 根据jobId找到job然后触发
    }
}
