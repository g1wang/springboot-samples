package com.example.startertest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class StarterTestApplicationTests {

    @Test
    void contextLoads() {
        //
        Date date = new Date();
        //时间戳
        System.out.println(date.getTime());
        //
        System.out.println(date.getDate());
        LocalDate today = LocalDate.now();  // 当前日期
        System.out.println(today.toString());
        LocalDateTime now = LocalDateTime.now();  // 当前日期和时间
        System.out.println(now.toString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(dtf);
        System.out.println(formattedNow);




    }

}
