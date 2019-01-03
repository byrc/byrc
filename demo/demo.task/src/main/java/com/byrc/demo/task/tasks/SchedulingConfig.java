
package com.byrc.demo.task.tasks;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
@EnableScheduling // 启用定时任务（项目中有一个类使用了这个注解就可以了）
public class SchedulingConfig implements SchedulingConfigurer
{
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //设定一个长度10的定时任务线程池,  多线程定时任务
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(9));
    }

}
