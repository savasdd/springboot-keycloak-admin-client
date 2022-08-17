package com.sinav.utils;

import com.sinav.service.UserGorevService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Autowired
    private UserGorevService service;

    // @Scheduled(fixedRate = 50000)
    @Scheduled(cron = "0 0/3 * * * ?") // 3 dk
    //@Scheduled(cron = "0 30 23 * * ?") // 23:30
    public void reportCurrentTime() {
        log.info("======> START JOBS [ " + df.format(new Date()) + " ] <======");
        service.getGorev().addAraGorev();
    }

    // * * * * * * *
    // 1=second (0 - 59)
    // 2=minute (0 - 59)
    // 3=hour (0 - 23)
    // 4=day of month (1 - 31)
    // 5=month (1 - 12)
    // 6=day of week (0 - 6) (Sunday=0 or 7)
    // 7=year

}
