package com.demo.ukgauthdemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UkgCronJob {

    private final UkgApiService ukgApiService;

    public UkgCronJob(UkgApiService ukgApiService) {
        this.ukgApiService = ukgApiService;
    }

    @Scheduled(fixedRate = 30000)
    public void runJob() {


        System.out.println("Cron triggered");

        ukgApiService.callUkgApi();
    }
}