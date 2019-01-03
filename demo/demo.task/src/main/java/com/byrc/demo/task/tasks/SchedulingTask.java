
package com.byrc.demo.task.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SchedulingTask
{
    Logger logger = LoggerFactory.getLogger(SchedulingTask.class);

    @Scheduled(cron = "0/2 * * * * ?")  //@Scheduled来创建定时任务 这个注解用来标注一个定时任务方法
    public void action2()
    {
        logger.info("Drink water -------------------------------------");
    }

    @Scheduled(cron ="0/3 * * * * ?")
    public void action3(){
        logger.info("eat biscuits===================================================");
    }

    @Scheduled(cron = "0/15 * * * * ?")
    public void action1() {
        logger.warn("play football --start------");
        List<String> list = new ArrayList<>();
        for(int i=0; i<100; i++){
            list.add(String.valueOf(100+i));
        }

        list.parallelStream().forEach(str -> {
            if(0 == Integer.parseInt(str)%10)
                logger.info("play football goal={}",str);
        });
        logger.warn("play football --end--------");
    }


}
