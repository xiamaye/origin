package com.example.shiro.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskeEx {

    @Scheduled(cron = "*/5 * * * * ?")
    public void task(){
        log.info("运行");

    }
}
