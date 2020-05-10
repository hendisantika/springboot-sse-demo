package com.hendisantika.springbootssedemo.service;

import com.hendisantika.springbootssedemo.model.StockPrice;
import com.hendisantika.springbootssedemo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sse-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/20
 * Time: 06.45
 */
@Service
public class StockPriceService {

    @Autowired
    private Utils utilities;

    public Flux<List<StockPrice>> getStockPriceData(List<StockPrice> stockPriceList) {

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));
        interval.subscribe((i) -> stockPriceList.forEach(stock -> setStockPrice(stock)));
        Flux<List<StockPrice>> transactionFlux = Flux.fromStream(Stream.generate(() -> stockPriceList));
        return Flux.zip(interval, transactionFlux).map(Tuple2::getT2);
    }

    private StockPrice setStockPrice(StockPrice stock) {
        stock.setPrice(utilities.getRandomDoubleBetweenRange(1000, 5000));
        stock.setValue(utilities.getRandomDoubleBetweenRange(1000, 5000));
        stock.setChange(utilities.getRandomDoubleBetweenRange(10, 50));
        stock.setStatus(utilities.getStatus());
        return stock;
    }
}
