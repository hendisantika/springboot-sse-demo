package com.hendisantika.springbootssedemo.controller;

import com.hendisantika.springbootssedemo.model.StockPrice;
import com.hendisantika.springbootssedemo.service.StockPriceService;
import com.hendisantika.springbootssedemo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sse-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/20
 * Time: 06.46
 */
@RestController
public class SSEController {

    private final List<StockPrice> stockPriceList = new ArrayList<>();

    @Autowired
    private Utils utils;

    @Autowired
    private StockPriceService stockPriceService;

}
