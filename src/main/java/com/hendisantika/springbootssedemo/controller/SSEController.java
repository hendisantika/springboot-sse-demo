package com.hendisantika.springbootssedemo.controller;

import com.hendisantika.springbootssedemo.model.StockPrice;
import com.hendisantika.springbootssedemo.service.StockPriceService;
import com.hendisantika.springbootssedemo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void initializeStockObjects() {

        StockPrice stock1 = new StockPrice("ABC BANK",
                utils.getRandomDoubleBetweenRange(1000, 5000), utils.getRandomDoubleBetweenRange(5, 15),
                utils.getRandomDoubleBetweenRange(1000, 5000), utils.getStatus());

        StockPrice stock2 = new StockPrice("RELIANCE",
                utils.getRandomDoubleBetweenRange(1000, 5000), utils.getRandomDoubleBetweenRange(5, 15),
                utils.getRandomDoubleBetweenRange(1000, 5000), utils.getStatus());

        StockPrice stock3 = new StockPrice("KOTAK",
                utils.getRandomDoubleBetweenRange(1000, 5000), utils.getRandomDoubleBetweenRange(5, 15),
                utils.getRandomDoubleBetweenRange(1000, 5000), utils.getStatus());

        stockPriceList.add(stock1);
        stockPriceList.add(stock2);
        stockPriceList.add(stock3);
    }


    @GetMapping(value = "/stockprice", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<StockPrice>> getStockPrice() {
        return stockPriceService.getStockPriceData(stockPriceList);
    }
}
