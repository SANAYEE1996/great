package com.best.great.service;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class HomeService {
    public String getStringCurrentDateTime() {
        LocalDateTime currentDate = LocalDateTime.now();
        String currentDateTime = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return currentDateTime;
    }
}
