package xyz.liinns.quarzt;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Description:
 * Created by LiinNs on 2017-5-5 0005.
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.printf("Quartz is great!");
    }
}
