package com.hendisantika.springbootssedemo.util;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sse-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/20
 * Time: 06.43
 */
@Component
public class Utils {

    public String getRandomDoubleBetweenRange(double min, double max) {
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format((Math.random() * ((max - min) + 1)) + min);
        return format;
    }

    public String getStatus() {
        int i = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        String[] status = {"HIGH", "LOW"};
        return status[i];
    }
}
