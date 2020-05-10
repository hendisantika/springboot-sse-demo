package com.hendisantika.springbootssedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sse-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/20
 * Time: 06.41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockPrice {

    private String companyName;
    private String price;
    private String change;
    private String value;
    private String status;
}
